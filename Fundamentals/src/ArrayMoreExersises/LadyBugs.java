package ArrayMoreExersises;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] bugsPosition = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] field = new int[fieldSize];

//        for (int bugPosition:bugsPosition) {
//            field[bugPosition] = 1;
//        }
        for (int i = 0; i < bugsPosition.length; i++) {
            int index = bugsPosition[i];
            if (index >= 0 && index < field.length) {
                field[index] = 1;
            }
        }
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end")) {
            String[] command = inputLine.split(" ");
            int index1 = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLength = Integer.parseInt(command[2]);

            if (index1 < 0 || index1 >= field.length || field[index1] != 1) {
                inputLine = scanner.nextLine();
                continue;
            }
            field[index1] = 0;
            switch (direction) {
                case "right":
                    index1 += flyLength;
                    while (index1 < fieldSize && field[index1] == 1) {
                        index1 += flyLength;
                    }
                    if (index1 < field.length) {
                        field[index1] = 1;
                    }

                    break;
                case "left":
                    index1 -= flyLength;
                    while (index1 >= 0 && field[index1] == 1) {
                        index1 -= flyLength;
                    }
                    if (index1 >= 0) {
                        field[index1] = 1;
                    }
                    break;
            }


            inputLine = scanner.nextLine();
        }

        Arrays.stream(field).forEach(e -> System.out.print(e + " "));
    }
}

