package WhileLoopExam;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int dishDetergent = Integer.parseInt(scanner.nextLine());

        int detergentMl = 750;
        int onePlate = 5;
        int onePot = 15;

        int countPlate = 0;
        int countPot = 0;
        int dishes = 0;
        int pots = 0;
        int count = 0;

        int detergent = dishDetergent * detergentMl;


        while(detergent >= 0){
            String input = scanner.nextLine();
            if (input.equals("End")){
                break;
            }
            int plateOrPot = Integer.parseInt(input);
            count ++;
            if (count % 3 == 0) {

                countPot = plateOrPot * 15;
                pots += plateOrPot ;
                detergent -= countPot;
            }else{
                countPlate = plateOrPot * 5;
                dishes += plateOrPot ;
                detergent -= countPlate;
            }
        }
        if (detergent >= 0){
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", dishes, pots);
            System.out.printf("Leftover detergent %d ml.%n", detergent);
        }else{
            System.out.printf("Not enough detergent, %d ml. more necessary!%n", Math.abs(detergent));
        }
    }
}
