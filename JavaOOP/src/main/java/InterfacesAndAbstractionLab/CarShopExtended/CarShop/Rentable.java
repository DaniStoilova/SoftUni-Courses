package InterfacesAndAbstractionLab.CarShopExtended.CarShop;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
