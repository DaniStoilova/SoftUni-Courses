package MoreExercises;

import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());

        double circleArea = Math.PI*Math.pow(r,2);
        double circleParameter = 2*Math.PI*r;

        System.out.printf("%.2f %n%.2f", circleArea, circleParameter);



    }
}
