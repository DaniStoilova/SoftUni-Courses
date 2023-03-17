package ForLoop;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());


        int toys = 0;
        int money = 0;
        int totalSum = 0;
        int countBrother = 0;

        for (int i=1; i <= age; i++){
            if (i % 2 != 0){
                toys += 1;
            }else{
                money = money + 10;
                totalSum = totalSum + money;

                countBrother += 1;

            }
        }

        int sum = (toys * toyPrice) + totalSum - countBrother;

        double diff = Math.abs(sum - washingMachinePrice);
        if (sum >= washingMachinePrice) {
            System.out.printf("Yes! %.2f",diff);

        }else{
            System.out.printf("No! %.2f", diff);
        }
    }
}
