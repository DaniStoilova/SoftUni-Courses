package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskWrapper {

    @XmlElement(name="task")
    List<TaskImportModel> tasks;


    public List<TaskImportModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskImportModel> tasks) {
        this.tasks = tasks;
    }
}
