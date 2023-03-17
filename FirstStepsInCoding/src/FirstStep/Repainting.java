package FirstStep;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nylonQuantity = Integer.parseInt(scanner.nextLine());
        int paintQuantity = Integer.parseInt(scanner.nextLine());
        int razrQuantity= Integer.parseInt(scanner.nextLine());
        int countHours = Integer.parseInt(scanner.nextLine());
        double priceAllNylon = (nylonQuantity+2) * 1.50;
        double priceAllPaint = (paintQuantity*1.10) * 14.50;
        double priceAllRazr = razrQuantity * 5.00;

        double allMaterialsPrice = priceAllNylon+priceAllPaint+priceAllRazr+0.40;
        double workerPrice = (allMaterialsPrice*0.30)*countHours;
        double totalSum = allMaterialsPrice + workerPrice;
        System.out.println(totalSum);











    }
}
