package ExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String stops = scanner.nextLine();

        String input = scanner.nextLine();

        StringBuilder stopBuilder = new StringBuilder(stops);

        while (!input.equals("Travel")) {
            if (input.contains("Add Stop")) {
                int index = Integer.parseInt(input.split(":")[1]);
                String stopName = input.split(":")[2];
                if (isValidIndex(index, stopBuilder)) {
                    stopBuilder.insert(index, stopName);
                }

            } else if (input.contains("Remove Stop")) {
                int startIndex = Integer.parseInt(input.split(":")[1]);
                int endIndex = Integer.parseInt(input.split(":")[2]);

                if (isValidIndex(startIndex, stopBuilder) && isValidIndex(endIndex, stopBuilder)) {


                    stopBuilder.delete(startIndex, endIndex + 1);
                }


            } else if (input.contains("Switch")) {
                String oldString = input.split(":")[1];
                String newString = input.split(":")[2];

                if (stops.contains(oldString)) {
                    String updateText = stopBuilder.toString().replace(oldString, newString);
                    stopBuilder = new StringBuilder(updateText);
                }

            }


            System.out.println(stopBuilder.toString());


            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stopBuilder);

    }

    public static boolean isValidIndex(int index, StringBuilder builder) {


        return index >= 0 && index <= builder.length() - 1;
    }

}

