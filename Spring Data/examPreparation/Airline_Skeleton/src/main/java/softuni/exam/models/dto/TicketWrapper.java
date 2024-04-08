package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketWrapper {

    @XmlElement(name="ticket")
    List<TicketImport> ticket;

    public List<TicketImport> getTicket() {
        return ticket;
    }

    public void setTicket(List<TicketImport> ticket) {
        this.ticket = ticket;
    }
}
