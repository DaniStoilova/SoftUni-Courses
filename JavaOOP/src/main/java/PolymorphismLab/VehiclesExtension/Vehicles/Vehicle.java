package PolymorphismLab.VehiclesExtension.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    private double tankCapacity;

    private double additionalAC;



    public Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity,double additionalAC) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
        this.additionalAC = additionalAC;
    }
    public String driveAC(double distance){
        setFuelConsumption(getFuelConsumption() + additionalAC);
        String result = this.drive(distance);
        setFuelConsumption(getFuelConsumption() - additionalAC);
        return result;

    }
    public String drive(double distance){
       double fuelNeeded = getFuelConsumption() * distance;
       if (fuelNeeded > getFuelQuantity()){
           return this.getClass().getSimpleName() + " needs refueling";
       }
       setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",this.getClass().getSimpleName(),df.format(distance));

    }
    public  void refuel(double liters ){
        if (liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity + liters > tankCapacity){
            throw  new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;

    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),fuelQuantity);
    }
}
