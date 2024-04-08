package softuni.exam.models.dto;

import java.math.BigDecimal;

public class TaskCoupeDTO {
    private Long id;
    private BigDecimal price;
    private MechanicBasicInfo mechanic;
    private CarBasicInfoDto car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MechanicBasicInfo getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBasicInfo mechanic) {
        this.mechanic = mechanic;
    }

    public CarBasicInfoDto getCar() {
        return car;
    }

    public void setCar(CarBasicInfoDto car) {
        this.car = car;
    }
}
