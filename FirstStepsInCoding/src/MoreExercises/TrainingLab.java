package MoreExercises;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());

        int centimeters = 100;
        int widthCentimeters =  (int) (width * 100) ;
        int widthWithoutCorridor = widthCentimeters-100;
        int oneDesk = widthWithoutCorridor/70;

        int lengthCentimeters = (int) (length * 100);
        int onePlace = lengthCentimeters/120;

        int allPlace = (oneDesk * onePlace) - 3;

        System.out.println(allPlace);



    }
}
