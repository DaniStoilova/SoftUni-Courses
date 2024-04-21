package WorkingWithAbstraction.HotelReservation.hotelReservation;

public enum DiscountType {

    None("None",0),
    VIP("VIP",20),
    SecondVisit("SecondVisit",10);
    private String name;
    private double percent;

    DiscountType(String name,double percent){
        this.name = name;
        this.percent = percent;
    }
    public String getName(){
        return name;
    }
    public double getPercent(){
        return percent;
    }
    public void setName(String name){
         this.name = name;
    }
    public void setPercent(double percent){
        this.percent = percent;
    }


}
