package DefiningClassesLab.CarInfo;

public class CarInfo {
    private String brand;
    private String model;
    private int horsePower;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getBrand(String s) {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                brand, model, horsePower);

    }

}
