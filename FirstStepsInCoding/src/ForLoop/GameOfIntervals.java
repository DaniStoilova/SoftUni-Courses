package ForLoop;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());



        int p = 0;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        double point = 0;
        double total = 0;
        for (int i=0; i < count; i++){
            int currentNumber= Integer.parseInt(scanner.nextLine());
            total += currentNumber;
            if (currentNumber >= 0 && currentNumber <= 9){
                point = point + (0.2 * currentNumber);
                p +=1;
            }else if (currentNumber >=10 && currentNumber <= 19){
                point = point + (0.3 * currentNumber);
                p1 +=1;
            }else if (currentNumber >= 20 && currentNumber <= 29){
                point = point + (0.4 * currentNumber);
                p2 +=1;
            }else if (currentNumber >= 30 && currentNumber <= 39){
                point = point + 50;
                p3 +=1;
            }else if (currentNumber >= 40 && currentNumber <= 50){
                point =point + 100;
                p4 +=1;
            }else{
                 point = point/ 2;
                p5 +=1;

            }
        }
        System.out.printf("%.2f%n", point);
        System.out.printf("From 0 to 9: %.2f%%%n", p * 1.0/count * 100);
        System.out.printf("From 10 to 19: %.2f%%%n",p1 * 1.0/count * 100);
        System.out.printf("From 20 to 29: %.2f%%%n",p2 * 1.0/count * 100);
        System.out.printf("From 30 to 39: %.2f%%%n",p3 * 1.0/count * 100);
        System.out.printf("From 40 to 50: %.2f%%%n",p4 * 1.0/count * 100);
        System.out.printf("Invalid numbers: %.2f%%%n",p5 * 1.0/count * 100);

    }
}
