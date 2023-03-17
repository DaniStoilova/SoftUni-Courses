package FirstStep;

import java.util.Scanner;

public class SuppliesToSchool {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int pensCount = Integer.parseInt(scanner.nextLine());
        int markersCount = Integer.parseInt(scanner.nextLine());
        int litersDetergent = Integer.parseInt(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());
      //himikal - 5.80 marker - 7.20  preparat - 1.20
        double priceAllPens = pensCount * 5.80;
        double priceAllMarkers = markersCount * 7.20;
        double priceLitersDetergent = litersDetergent * 1.20;
        double sumTotal = priceAllPens + priceAllMarkers + priceLitersDetergent;
        double sumWithDiscount = sumTotal-(sumTotal*percentDiscount/100);
        System.out.println(sumWithDiscount);




    }
}
