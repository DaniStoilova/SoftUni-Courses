package MidExam;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> num = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Collections.sort(num);
       //Collections.reverse(num);
        int sum = 0;
        for (int i = 0; i <= num.size() - 1; i++) {
            sum += Integer.parseInt(num.get(i));

        }
        int count = 0;
        double averageNum = sum * 1.0 / num.size();
        for (int i = num.size() - 1; i >=0; i--) {
            int currentNumber = Integer.parseInt(num.get(i));
            if (currentNumber > averageNum) {

                count++;

                System.out.print(currentNumber + " ");

            }
            if (count == 5) {
                break;
            }
        }

        if (num.size() - 1 == 0) {
            System.out.println("No");
        }

    }


}


