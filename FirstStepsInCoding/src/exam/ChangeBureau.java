package exam;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //•	1 биткойн = 1168 лева.
        //•	1 китайски юан = 0.15 долара.
        //•	1 долар = 1.76 лева.
        //•	1 евро = 1.95 лева.
        int bitcoin = Integer.parseInt(scanner.nextLine());
        double chinaCoin = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double sumBitcoin = bitcoin * 1168;
        double sumChinaCoin = chinaCoin * 0.15;
        double sumDolar = sumChinaCoin * 1.76;

        double totalSumEuro = (sumBitcoin + sumDolar)/1.95;
        double totalCommission = totalSumEuro*commission/100;
        double result = totalSumEuro - totalCommission;

        System.out.printf("%.2f", result);

    }

}
