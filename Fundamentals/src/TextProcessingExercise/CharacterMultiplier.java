package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");

        String first = inputLine[0];
        String second = inputLine[1];

        long sum = calculateSum(first, second);

        System.out.println(sum);

    }

    private static long calculateSum(String first, String second) {

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        int minLen = Math.min(firstArr.length, secondArr.length);

        int maxLen = Math.max(firstArr.length, secondArr.length);
        long sum = 0;
        for (int i = 0; i < minLen; i++) {


            sum += firstArr[i] * secondArr[i];
        }
        if (firstArr.length == maxLen) {
            for (int i = minLen; i < maxLen; i++) {
                sum += firstArr[i];
            }

        } else {
            for (int i = minLen; i < maxLen; i++) {

                sum += secondArr[i];

            }

        }
        return sum;
    }
}
