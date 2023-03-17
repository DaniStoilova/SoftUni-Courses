package Lab;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int videoCard = Integer.parseInt(scanner.nextLine());
        int cpu = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());

        double sumVideoCards = videoCard * 250.0;
        double priceCpu = sumVideoCards * 0.35;
        double sumCpu = cpu * priceCpu;
        double priceRam = sumVideoCards * 0.10;
        double sumRam = ram * priceRam;

        double allSum = sumVideoCards + sumCpu + sumRam;
        double discount = 0.0;
        if (videoCard > cpu){
            discount = allSum - (allSum*0.15);
        }else{
            discount =allSum;
        }
        double diff = Math.abs(budget - discount);
        if (discount <= budget) {
            System.out.printf("You have %.2f leva left!", diff);
        }else{
            System.out.printf("Not enough money! You need %.2f leva more!", diff);
        }
    }
}
