package AdvanceConditionalStatement;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();

        switch (dayOfWeek) {
            case "Monday":
                if (hour >= 10 && hour <= 18) {
                    System.out.println("open");
                    break;
                }
            case "Tuesday":
                if (hour >= 10 && hour <= 18) {
                    System.out.println("open");
                    break;
                }
            case "Wednesday":
                if (hour >= 10 && hour <= 18) {
                    System.out.println("open");
                    break;
                }
            case "Thursday":
                if (hour >= 10 && hour <= 18) {
                    System.out.println("open");
                    break;
                }
            case "Friday":
                if (hour >= 10 && hour <= 18) {
                    System.out.println("open");
                    break;
                }
            case "Saturday":
                if (hour >= 10 && hour <= 18) {
                    System.out.println("open");
                    break;
                }
            default:
            case "Sunday":
                System.out.println("closed");

            }
        }
    }

