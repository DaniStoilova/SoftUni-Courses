package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketImport;
import softuni.exam.models.dto.TicketWrapper;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Plane;
import softuni.exam.models.entity.Ticket;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    private static String TICKET_PATH = "src/main/resources/files/xml/tickets.xml";
    private PlaneRepository planeRepository;
    private PassengerRepository passengerRepository;

    private TownRepository townRepository;

    private XmlParser xmlParser;

    private ModelMapper modelmapper;

    private ValidationUtils validationUtils;

    private TicketRepository ticketRepository;

    public TicketServiceImpl(PlaneRepository planeRepository, PassengerRepository passengerRepository, TownRepository townRepository, XmlParser xmlParser, ModelMapper modelmapper, ValidationUtils validationUtils, TicketRepository ticketRepository) {
        this.planeRepository = planeRepository;
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.modelmapper = modelmapper;
        this.validationUtils = validationUtils;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKET_PATH));
    }

    @Override
    public String importTickets() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        List<TicketImport> ticket = xmlParser.fromFile(TICKET_PATH, TicketWrapper.class).getTicket();

        for (TicketImport ticketImport : ticket) {

            Optional<Town> from = townRepository.findFirstByName(ticketImport.getFromTown().getName());
            Optional<Town> to = townRepository.findFirstByName(ticketImport.getToTown().getName());
            Optional<Plane> registerNumber = planeRepository.findFirstByRegisterNumber(ticketImport.getPlane().getRegisterNumber());
            Optional<Passenger> email = passengerRepository.findFirstByEmail(ticketImport.getPassenger().getEmail());


            if (!validationUtils.isValid(ticketImport) || from.isEmpty() || to.isEmpty() ||
            registerNumber.isEmpty() || email.isEmpty()){
                sb.append("Invalid Ticket")
                        .append(System.lineSeparator());
                continue;

            }
            Ticket ticketToSave = this.modelmapper.map(ticketImport, Ticket.class);
            ticketToSave.setFromTown(from.get());
            ticketToSave.setToTown(to.get());
            ticketToSave.setPlane(registerNumber.get());
            ticketToSave.setPassenger(email.get());

            ticketRepository.save(ticketToSave);

            sb.append(String.format("Successfully imported Ticket %s - %s",
                    ticketImport.getFromTown().getName(),
                    ticketImport.getToTown().getName())).append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
