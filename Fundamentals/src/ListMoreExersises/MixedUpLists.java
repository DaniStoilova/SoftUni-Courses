package ListMoreExersises;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNum = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNum = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int minSize = Math.min(firstNum.size(), secondNum.size());

        List<Integer> result = new ArrayList<>(minSize);


        Collections.reverse(secondNum);


        for (int i = 0; i < minSize; i++) {
            int first = firstNum.get(i);
            int second = secondNum.get(i);

            result.add(first);
            result.add(second);

        }
        int constraintsOne = 0;
        int constraintsTwo = 0;

        if (firstNum.size() > secondNum.size()) {

            constraintsOne = firstNum.get(firstNum.size() - 1);
            constraintsTwo = firstNum.get(firstNum.size() - 2);

            Collections.sort(result);

            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) > constraintsOne && result.get(i) < constraintsTwo ||
                        result.get(i) < constraintsOne && result.get(i) > constraintsTwo) {

                    System.out.print(result.get(i) + " ");
                }

            }
        } else {

            constraintsOne = secondNum.get(secondNum.size() - 1);
            constraintsTwo = secondNum.get(secondNum.size() - 2);

            Collections.sort(result);

            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) > constraintsOne  && result.get(i) < constraintsTwo) {



                    System.out.print(result.get(i) + " ");

                }
            }
        }

    }
}





