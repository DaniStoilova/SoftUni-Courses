package WorkingWithAbstraction.HotelReservation.hotelReservation;

public class PriseCalculator {
        public static double calculateHoliday(double pricePerDay,int numberOfDays,Season season,
                                              DiscountType discountType){

        double priceAllDay = pricePerDay * numberOfDays;
        priceAllDay *= season.getMultiplyCoefficient();

        priceAllDay = priceAllDay - priceAllDay * (discountType.getPercent()/100);


        return priceAllDay;
        }


}
