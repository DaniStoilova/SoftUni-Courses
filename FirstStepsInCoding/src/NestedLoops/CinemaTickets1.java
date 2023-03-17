package NestedLoops;

import MoreExercises.Scannner;

import java.util.Scanner;

public class CinemaTickets1 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);


        int countStandard = 0;
        int countKid = 0;
        int countStudent = 0;

        String movie = scanner.nextLine();
        while (!movie.equals("Finish")){
            int free = Integer.parseInt(scanner.nextLine());
            int counter = 0;
            label:
            for (int i = 0; i < free; i++){
                String input = scanner.nextLine();
                switch (input) {
                    case "student":
                        countStudent++;
                        break;
                    case "standard":
                        countStandard++;
                        break;
                    case "kid":
                        countKid++;
                        break;
                    case "End":
                        break label;
                }
                counter++;
            }
            System.out.printf("%s - %.2f%% full.%n" , movie, counter * 1.0/free * 100);
            movie = scanner.nextLine();
        }
        int total = countKid + countStandard + countStudent;
        System.out.printf("Total tickets: %d%n",total );
        System.out.printf("%.2f%% student tickets.%n", countStudent * 1.0/ total * 100);
        System.out.printf("%.2f%% standard tickets.%n", countStandard * 1.0 /total * 100);
        System.out.printf("%.2f%% kids tickets.%n", countKid* 1.0/total * 100);
    }
}








