package InterfacesAndAbstractionLab.CarShopExtended.CarShop;

public class Seat extends CarImpl implements Sellable{
    private Double price;
    public Seat(String model, String color, Integer horsePower, String countryProduced,Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Leon sells for %f",price));

        return sb.toString();
    }
}


