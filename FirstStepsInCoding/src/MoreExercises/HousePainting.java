package MoreExercises;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       double x =Double.parseDouble(scanner.nextLine());
       double y =Double.parseDouble(scanner.nextLine());
       double h =Double.parseDouble(scanner.nextLine());

       double areaWallSquare = x * x;
       double door = 1.2 * 2;
       double totalWallSquare = 2 * areaWallSquare - door;

       double areaWallRectangle = x * y;
       double window = 1.5 * 1.5;
       double totalWallRectangle = 2 * areaWallRectangle - 2 * window;

       double totalArea = totalWallRectangle + totalWallSquare;
       double greenPaint = totalArea/3.4;

       double areaRoofRectangle = x * y;
       double areaRoof = x*h/2;
       double totalAreaRoof = 2 * areaRoofRectangle + 2 * areaRoof;
       double redPaint = totalAreaRoof/4.3;

       System.out.printf("%.2f %n%.2f", greenPaint, redPaint);



    }
}
