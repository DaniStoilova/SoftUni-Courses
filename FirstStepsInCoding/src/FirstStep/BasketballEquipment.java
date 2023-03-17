package FirstStep;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //kecove  - 40%; ekip- -20% ot kecovete; ball - 1/4 ot ekip;aksesoarite- 1/5 ot ball;

        int yearTax = Integer.parseInt(scanner.nextLine());

        double priceShoes =  yearTax * 0.60;
        double priceSuit = priceShoes * 0.80;
        double priceBall = priceSuit/4;
        double priceAcc = priceBall/5;
        double totalPrice = yearTax + priceShoes + priceSuit + priceBall + priceAcc;
        System.out.printf("%.2f",totalPrice);


    }
}
