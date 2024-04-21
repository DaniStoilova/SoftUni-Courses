package PolymorphismLab.VehiclesExtension.Vehicles;

public class Bus extends Vehicle{
    private final static double ADDITIONAL_CONSUMPTION = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption , tankCapacity, ADDITIONAL_CONSUMPTION);

    }


}
