package MidExam;

import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxPeople = 4;

        int people = Integer.parseInt(scanner.nextLine());

        String[] elementArr = scanner.nextLine().split(" ");

        int[] current = new int[elementArr.length];

        boolean isFinish1 = false;
        while (people > 0) {


            for (int i = 0; i < elementArr.length; i++) {
                int element = Integer.parseInt(elementArr[i]);


                if (people <= 4) {
                    current[i] = people;
                } else {
                    current[i] = maxPeople;
                }


                people -= current[i] - element;

                if (current[i] == current[elementArr.length - 1]) {
                    isFinish1 = true;
                    break;
                }

            }
            isFinish1 = true;
            break;

        }
        isFinish1 = true;


        if (people == 0) {
            System.out.println("The lift has empty spots!");
            for (int element : current) {
                System.out.print(element + " ");
            }
        } else if (people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            for (int element : current) {
                System.out.print(element + " ");
            }
        } else {
            for (int element : current) {
                System.out.print(element + " ");
            }
        }
    }
}



