package WorkingWithAbstraction.HotelReservation.hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        String[] data = input.split(" ");

        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);
        Season season  = Season.valueOf(data[2]);
        DiscountType discountType = DiscountType.valueOf(data[3]);

        double holidayPrice = PriseCalculator.calculateHoliday(pricePerDay,numberOfDays,season,discountType);


        System.out.printf("%.2f",holidayPrice);



    }
}
