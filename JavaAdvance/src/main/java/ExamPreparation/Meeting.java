package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(females::offer);

        int count = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();
            if (male <= 0) {
                males.pop();

            } else if (female <= 0) {
                females.poll();


            }else if (male % 25 == 0){
                males.pop();
                males.pop();

            }else if (female % 25 == 0){
                females.poll();
                females.poll();

            }else if (male == female) {
                males.pop();
                females.poll();
                count++;

            } else {
                females.poll();
                male -= 2;
                males.pop();
                males.push(male);

            }

        }
        System.out.printf("Matches: %d%n",count);
        if (males.isEmpty()){
            System.out.println("Males left: none");
        }else{
            List<String> result = males.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Males left: "+ String.join(", ",result));
        }
        if (females.isEmpty()){
            System.out.println("Females left: none");
        }else{
            List<String> result = females.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Females left: " + String.join(", ",result));
        }




    }
}
