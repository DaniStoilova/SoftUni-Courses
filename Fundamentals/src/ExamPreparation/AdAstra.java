package ExamPreparation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();

        String regex = "(#|\\|)(?<product>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> list = new ArrayList<>();


        int total = 0;
        while (matcher.find()) {

            String product = matcher.group("product");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            total += calories;

           list.add(String.format("Item: %s, Best before: %s, Nutrition: %d",product,date,calories));

        }

        int days = total / 2000;

        System.out.printf("You have food to last you for: %d days!%n", days);

        for (String product:list) {
            System.out.println(product);
        }


    }
}
