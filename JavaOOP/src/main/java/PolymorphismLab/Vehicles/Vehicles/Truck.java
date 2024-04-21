package PolymorphismLab.Vehicles.Vehicles;

public  class Truck extends Vehicle {
    private final static double ADDITIONAL_CONSUMPTION = 1.6;
    private final static double FUEL_AFTER_REDUCTION = 0.95;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters){
        super.refuel(liters * FUEL_AFTER_REDUCTION);
    }


}
