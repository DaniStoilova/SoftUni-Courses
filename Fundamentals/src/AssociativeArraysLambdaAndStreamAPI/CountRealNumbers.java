package AssociativeArraysLambdaAndStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numberList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> countNumbersMap = new TreeMap<>();
        for (double currentNum : numberList) {
//            countNumbersMap.putIfAbsent(currentNum,0);
//            int value = countNumbersMap.get(currentNum);
//            countNumbersMap.put(currentNum,value + 1);

            Integer value = countNumbersMap.get(currentNum);
            if (countNumbersMap.containsKey(currentNum)) {
                countNumbersMap.put(currentNum, value + 1);
            } else {
                countNumbersMap.put(currentNum, 1);
            }

        }

        for (Map.Entry<Double, Integer> entry : countNumbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
