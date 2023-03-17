package ListLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);

            switch (command) {
                case "Contains":
                    int num = Integer.parseInt(commandLine.get(1));

                        if (numberList.contains(num)) {
                            System.out.println("Yes");
                        } else {
                            System.out.println("No such number");
                        }

                    break;
                case "Print":
                    String evenOrOdd = commandLine.get(1);
                    if (evenOrOdd.equals("even")) {
                        List<Integer> evenNumList = getEvenNumbers(numberList);
                        System.out.println(evenNumList.toString().replaceAll( "[\\[\\],]", ""));
                    }else{
                        List<Integer> oddNumList = getOddNumbers(numberList);
                        System.out.println(oddNumList.toString().replaceAll( "[\\[\\],]", ""));
                    }

                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numberList.size(); i++) {
                        int number = numberList.get(i);
                        sum  += number;

                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = commandLine.get(1);
                    int number = Integer.parseInt(commandLine.get(2));
                    List<Integer> conditionalNumList = getConditionalNumbers(numberList,condition,number);
                    System.out.println(conditionalNumList.toString().replaceAll( "[\\[\\],]", ""));
                    break;

            }
            input = scanner.nextLine();

        }
    }

    private static List<Integer> getConditionalNumbers(List<Integer> numberList, String condition, int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            int num = numberList.get(i);

            if (condition.equals("<")) {
                if (num < number) {
                    result.add(num);
                }

            } else if (condition.equals(">")) {
                if (num > number) {
                    result.add(num);
                }

            } else if (condition.equals(">=")) {
                if (num >= number) {
                    result.add(num);
                }

            } else if (condition.equals("<=")) {
                if (num <= number) {
                    result.add(num);
                }
            }
        }
        return result;
    }

    private static List<Integer> getOddNumbers(List<Integer> numberList) {
        List<Integer> oddNumberList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            int number = numberList.get(i);
            if (number % 2 == 1){
                oddNumberList.add(number);
            }

        }
        return oddNumberList;
    }

    private static List<Integer> getEvenNumbers(List<Integer> numberList) {
        List <Integer> evenNumberList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            int number = numberList.get(i);
            if (number % 2 == 0){
                evenNumberList.add(number);
            }

        }
    return evenNumberList;



    }
}