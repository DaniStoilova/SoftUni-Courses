package softuni.exam.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="teams")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamWrapper {
    @XmlElement(name="team")
    private List<TeamImport> team;

    public List<TeamImport> getTeam() {
        return team;
    }

    public void setTeam(List<TeamImport> team) {
        this.team = team;
    }
}
