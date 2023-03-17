package MethodsMoreExersises;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1  = Integer.parseInt(scanner.nextLine());
        int y1  = Integer.parseInt(scanner.nextLine());
        int x2  = Integer.parseInt(scanner.nextLine());
        int y2  = Integer.parseInt(scanner.nextLine());

        printCenterPoint(x1,y1,x2,y2);



    }
    private static void printCenterPoint(int x,int y,int a,int b){
        if (x <= a && y <= b){
            System.out.printf("(%d, %d)",x,y);
        }else if (a <= x && b <= y){
            System.out.printf("(%d, %d)",a,b);
        }
    }
}
