package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="forecasts")
public class Forecast extends BaseEntity {

    //•	id – accepts integer values, a primary identification field, an auto incremented field.
    //•	day of week – enumerated value, one of the following – FRIDAY, SATURDAY, SUNDAY. Cannot be null.
    //•	max temperature – a floating point number. Must be between -20 and 60 (both numbers are INCLUSIVE). Cannot be null.
    //•	min temperature – a floating point number. Must be between -50 and 40 (both numbers are INCLUSIVE). Cannot be null.
    //•	sunrise – time of the sunrise. Cannot be null.
    //•	sunset – time of the sunset. Cannot be null.
    //•	Constraint: The

    @Column(nullable = false,name="day_of_week")
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(nullable = false,name="max_temperature")

    private float maxTemperature;

    @Column(nullable = false,name="min_temperature")
    private float minTemperature;

    @Column(nullable = false)
    private LocalTime sunrise;

    @Column(nullable = false)
    private LocalTime sunset;

    @ManyToOne(optional = false)
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Forecast() {
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(float minTemperature) {
        this.minTemperature = minTemperature;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }
}
