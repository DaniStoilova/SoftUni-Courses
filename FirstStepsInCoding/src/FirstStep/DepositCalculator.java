package FirstStep;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        double deposit = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        //Izchislqvane
        double increase = deposit*(percent/100);
        double monthlyincrease = increase/12;
        double sum =deposit+(months*monthlyincrease);
        System.out.println(sum);








    }

}
