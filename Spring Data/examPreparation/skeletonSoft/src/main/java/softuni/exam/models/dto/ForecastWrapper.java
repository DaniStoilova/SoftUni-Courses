package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastWrapper {

    @XmlElement(name="forecast")
    List<ForecastImportWrapper> forecast;

    public List<ForecastImportWrapper> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastImportWrapper> forecast) {
        this.forecast = forecast;
    }
}
