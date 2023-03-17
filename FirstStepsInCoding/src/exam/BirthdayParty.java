package exam;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double rent = Double.parseDouble(scanner.nextLine());

        double priceCake = rent*0.20;
        double drink = priceCake*0.55;
        double animator = rent * 1/3;

        double totalSum = rent + priceCake + drink + animator;

        System.out.println(totalSum);
    }
}
