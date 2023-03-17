package MoreExercises;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int countDays = Integer.parseInt(scanner.nextLine());
        int foodKg = Integer.parseInt(scanner.nextLine());
        double foodOneDayDog = Double.parseDouble(scanner.nextLine());
        double foodOneDayCat = Double.parseDouble(scanner.nextLine());
        double foodOneDayTurtleGr = Double.parseDouble(scanner.nextLine());
        // 1 gram = 0.001kg
        double foodOneDayTurtleKg = foodOneDayTurtleGr * 0.001;
        double foodDog = countDays * foodOneDayDog;
        double foodCat = countDays * foodOneDayCat;
        double foodTurtle = countDays * foodOneDayTurtleKg;

        double totalFood = foodDog + foodCat + foodTurtle;
        double diff =Math.abs(foodKg-totalFood);
        if (totalFood <= foodKg) {
            System.out.printf("%.0f kilos of food left.", Math.floor(diff));
        }else{
            System.out.printf("%.0f more kilos of food are needed.",Math.ceil(diff));
        }
    }
}
