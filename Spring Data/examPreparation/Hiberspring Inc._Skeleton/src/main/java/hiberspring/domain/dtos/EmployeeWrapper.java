package hiberspring.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeWrapper {

    @XmlElement(name="employee")
    @NotNull
    private List<EmployeeImport> employee;

    public List<EmployeeImport> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeImport> employee) {
        this.employee = employee;
    }
}
