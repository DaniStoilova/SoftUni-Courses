package exam;

import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //•	Козунак  – 3.20 лв.
        //•	Яйца –  4.35 лв. за кора с 12 яйца
        //•	Курабии – 5.40 лв. за килограм
        //•	Боя за яйца - 0.15 лв. за яйце

        int countCake = Integer.parseInt(scanner.nextLine());
        int countEgg = Integer.parseInt(scanner.nextLine());
        int kgCookies = Integer.parseInt(scanner.nextLine());

        double priceCake = countCake * 3.20;
        double priceEggs = countEgg * 4.35;
        double priceCookies = kgCookies * 5.40;
        double pricePaint = countEgg * 12 * 0.15;
        double total = priceCake + priceEggs + priceCookies + pricePaint;

        System.out.printf("%.2f", total);

    }
}
