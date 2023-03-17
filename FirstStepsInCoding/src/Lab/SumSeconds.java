package Lab;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int sumSeconds = first + second + third;
        int min = sumSeconds / 60;
        int sec = sumSeconds % 60;
       //System.out.printf("%d:%02d", min, sec);

        if (sec<10) {
            System.out.printf("%d:0%d", min, sec);
        }else {
            System.out.printf("%d:%d", min, sec);
        }
    }
}
