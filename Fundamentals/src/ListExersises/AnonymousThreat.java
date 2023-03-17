package ListExersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("3:1")) {

            if (input.contains("merge")) {
                int startIndex = Integer.parseInt(input.split(" ")[1]);
                int endIndex = Integer.parseInt(input.split(" ")[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > text.size() - 1) {
                    endIndex = text.size() - 1;
                }

                boolean isValidIndex = startIndex >= 0 && startIndex <= text.size() - 1 && endIndex >= 0 && startIndex <= endIndex;

                if (isValidIndex) {
                    String result = "";
                    for (int i = startIndex; i <= endIndex; i++) {
                        String current = text.get(i);

                        result += current;

                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        text.remove(startIndex);
                    }
                    text.add(startIndex, result);
                }


            } else if (input.contains("divide")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                int parts = Integer.parseInt(input.split(" ")[2]);


                String divideText = text.get(index);
                text.remove(index);

                int partSize = divideText.length() / parts;
                int beginIndex = 0;
                for (int i = 1; i < parts; i++) {
                    text.add(index, divideText.substring(beginIndex, beginIndex + partSize));
                    index++;
                    beginIndex += partSize;

                }
                text.add(index, divideText.substring(beginIndex));

            }


            input = scanner.nextLine();

        }
//        for (String name:text) {
//            System.out.print(text + " ");
//        }
            System.out.println(String.join(" ",text));

    }
}
