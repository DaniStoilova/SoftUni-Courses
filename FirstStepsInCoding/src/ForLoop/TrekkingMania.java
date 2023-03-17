package ForLoop;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int countGroup = Integer.parseInt(scanner.nextLine());

        int musala = 0;
        int monblan = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;
        int total = 0;

        for (int i=1; i <= countGroup; i++){
            int group = Integer.parseInt(scanner.nextLine());
            total += group;
        if (group <= 5){
            musala += group;
        }else if (group <= 12){
            monblan += group;
        }else if (group <= 25){
            kilimandjaro += group;
        }else if (group <= 40){
            k2 += group;
        }else{
            everest +=group;
        }

        }
        System.out.printf("%.2f%%%n", musala * 1.0/total * 100);
        System.out.printf("%.2f%%%n", monblan * 1.0/total * 100);
        System.out.printf("%.2f%%%n", kilimandjaro * 1.0/total * 100);
        System.out.printf("%.2f%%%n", k2 * 1.0/total * 100);
        System.out.printf("%.2f%%%n", everest * 1.0/total * 100);

    }
}
