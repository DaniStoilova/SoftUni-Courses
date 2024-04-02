package DefiningClassesExercises.RawData.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPer1Km;
    private int distance;

    public Car(String model,double fuelAmount, double fuelPer1Km){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km= fuelPer1Km;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPer1Km() {
        return fuelCostPer1Km;
    }

    public int getDistance() {
        return distance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelPer1Km(double fuelPer1Km) {
        this.fuelCostPer1Km = fuelPer1Km;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    @Override
    public String toString(){
        return String.format("%s %.2f %d",model,fuelAmount,distance);
    }
}
