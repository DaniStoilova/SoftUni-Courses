package ListExersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numberList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] bombNum = scanner.nextLine().split(" ");
        int bombElement = Integer.parseInt(bombNum[0]);
        int power = Integer.parseInt(bombNum[1]);
        int sum = 0;
        while (numberList.contains(bombElement)) {
            int index = numberList.indexOf(bombElement);

            int left = Math.max(0, index - power);
            int right = Math.min(index + power, numberList.size() - 1);


            for (int i = right; i >= left; i--) {

                numberList.remove(i);


            }

        }
        for (int i = 0; i < numberList.size(); i++) {
            sum += numberList.get(i);
        }
        System.out.println(sum);
    }

}


