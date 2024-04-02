package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(daffodils::offer);

        int count = 0;
        int countFlowersLater = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()){
            int first = tulips.peek();
            int second = daffodils.peek();

            int sum = first + second;

            if (sum == 15){
                tulips.pop();
                daffodils.poll();
                count++;
            }else if (sum > 15){
                first -= 2;
                tulips.pop();
                tulips.push(first);
            }else if (sum < 15){
                countFlowersLater += sum;

                tulips.pop();
                daffodils.poll();

            }



        }
        int bouquet = (int) Math.floor(countFlowersLater * 1.0/15);

        int result = 5 - (bouquet + count);

        if (count >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",count);
        }else{
            System.out.printf("You failed... You need more %d bouquets.",result);
        }


    }
}
