package ForLoop;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String nameActor = scanner.nextLine();
        double pointAcademy = Double.parseDouble(scanner.nextLine());
        int countN = Integer.parseInt(scanner.nextLine());


        double total = pointAcademy;
        for (int i=1; i <= countN; i++){
            String nameEvaluating = scanner.nextLine();
            double pointEvaluating = Double.parseDouble(scanner.nextLine());
            //205 + ((11 * 45) / 2) = 452.5
            double point = nameEvaluating.length()* pointEvaluating/2;
            if ( total < 1250.50) {
                total = total + point;

            }
        }
        double diff = Math.abs( total - 1250.50);
        if ( total <= 1250.50){
            System.out.printf("Sorry, %s you need %.1f more!", nameActor,diff );
        }else{
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!",nameActor,total);
        }
    }
}
