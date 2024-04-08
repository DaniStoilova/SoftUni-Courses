package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferImport;
import softuni.exam.models.dto.OfferWrapper;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private static String OFFER_PATH = "src/main/resources/files/xml/offers.xml";

    private OfferRepository offerRepository;
    private SellerRepository sellerRepository;

    private CarRepository carRepository;

    private PictureRepository pictureRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    public OfferServiceImpl(OfferRepository offerRepository, SellerRepository sellerRepository, CarRepository carRepository, PictureRepository pictureRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.offerRepository = offerRepository;
        this.sellerRepository = sellerRepository;
        this.carRepository = carRepository;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }

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

        List<OfferImport> offer = xmlParser.fromFile(OFFER_PATH, OfferWrapper.class).getOffer();

        for (OfferImport offerImport : offer) {

            if (!validationUtils.isValid(offerImport)){

                sb.append("Invalid offer")
                        .append(System.lineSeparator());
                continue;
            }

            Offer offerToSave = this.modelMapper.map(offerImport, Offer.class);

            offerToSave.setCar(carRepository.findById(offerImport.getCar().getId()).get());
            offerToSave.setSeller(sellerRepository.findById(offerImport.getSeller().getId()).get());
            
            offerRepository.save(offerToSave);


            sb.append(String.format("Successfully import offer %s - %s",
                            offerImport.getAddedOn(),
                    offerImport.getHasGoldStatus()))
                    .append(System.lineSeparator());

        }



        return sb.toString().trim();
    }
}
