package ArrayMoreExersises;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());


//Трябва да изберете последователността с най-дългата подпоследователност от единици. Ако има няколко последователности с
// еднаква дължина на подпоследователност от единици, отпечатайте тази с най-левия начален индекс, ако има няколко
// последователности с еднаква дължина и начален индекс, изберете последователността с по-голямата сума от нейните елементи.

        String input = scanner.nextLine();
        while (!input.equals("Clone them!")) {
            String[] command = input.split("!");

            int[] numbers = new int[length];

            int count = 0;
            int elements = 0;
            int maxSequence = 0;

            for (int i = 0; i <= length - 1; i++) {
                numbers[i] = Integer.parseInt(command[i]);
             int  ele = numbers[i];
             int ele1 = numbers[i + 1];
            }
//            if (ele == ele1) {
//                count++;
//            }
//            if (maxSequence < count) {
//                maxSequence = count;
//                elements = ele;
//            }


        }


        input = scanner.nextLine();
    }


}

