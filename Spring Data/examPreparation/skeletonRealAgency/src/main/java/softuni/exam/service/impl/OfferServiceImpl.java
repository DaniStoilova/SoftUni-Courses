package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferWrapper;
import softuni.exam.models.dto.OffersImport;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
    private static String OFFER_PATH = "src/main/resources/files/xml/offers.xml";

    public OfferServiceImpl(OfferRepository offerRepository, TownRepository townRepository, ModelMapper modelMapper, ValidationUtils validationUtils, XmlParser xmlParser, ApartmentRepository apartmentRepository, AgentRepository agentRepository) {
        this.offerRepository = offerRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
        this.apartmentRepository = apartmentRepository;
        this.agentRepository = agentRepository;
    }

    private OfferRepository offerRepository;

    private TownRepository townRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private XmlParser xmlParser;

    private ApartmentRepository apartmentRepository;

    private AgentRepository agentRepository;

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        List<OffersImport> offers =
                this.xmlParser.fromFile(OFFER_PATH, OfferWrapper.class)
                .getOffers();


        for (OffersImport offer : offers) {

            Optional<Apartment> apartment =
                    this.apartmentRepository.findById(offer.getApartment().getId());

            Optional<Agent> agent =
                    this.agentRepository.findFirstByFirstName(offer.getAgent().getName());

            if (apartment.isEmpty() || agent.isEmpty() || !validationUtils.isValid(offer)) {
                sb.append("Invalid offer")
                        .append(System.lineSeparator());
                continue;
            }

            Offer offerToSave = this.modelMapper.map(offer, Offer.class);
            offerToSave.setAgent(agent.get());
            offerToSave.setApartment(apartment.get());

            this.offerRepository.save(offerToSave);
            sb.append(String.format("Successfully imported offer %.2f",offerToSave.getPrice()))
                    .append(System.lineSeparator());

        }

        return sb.toString();
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();

        List<Offer> offerListThreeRooms = offerRepository.findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms);

        offerListThreeRooms
                .forEach(offer -> {
                    sb.append(String.format("Agent %s %s with offer №%d:%n" +
                                            "   -Apartment area: %.2f%n" +
                                            "   --Town: %s%n" +
                                            "   ---Price: %.2f$",
                                    offer.getAgent().getFirstName(),
                                    offer.getAgent().getLastName(),
                                    offer.getId(),
                                    offer.getApartment().getArea(),
                                    offer.getApartment().getTown().getTownName(),
                                    offer.getPrice()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
