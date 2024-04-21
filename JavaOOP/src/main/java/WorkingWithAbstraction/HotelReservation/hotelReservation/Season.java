package WorkingWithAbstraction.HotelReservation.hotelReservation;

public enum Season {
    Summer("Summer",4),
    Autumn("Autumn",1),
    Winter("Winter",3),
    Spring("Spring",2);

    private String name;
    private int multiplyCoefficient;

    Season(String name, int multiplyCoefficient) {
        this.name = name;
        this.multiplyCoefficient = multiplyCoefficient;
    }

    public String getName() {
        return name;
    }

    public int getMultiplyCoefficient() {
        return multiplyCoefficient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMultiplyCoefficient(int multiplyCoefficient) {
        this.multiplyCoefficient = multiplyCoefficient;
    }
}
