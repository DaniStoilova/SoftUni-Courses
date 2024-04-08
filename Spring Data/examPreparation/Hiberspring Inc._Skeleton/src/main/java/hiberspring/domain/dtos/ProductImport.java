package hiberspring.domain.dtos;

import hiberspring.domain.entities.Branch;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImport {

    @NotNull
    @XmlAttribute(name="name")
    private String name;
    @NotNull
    @XmlAttribute(name="clients")
    private Integer clients;

    @XmlElement
    @NotNull
    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
