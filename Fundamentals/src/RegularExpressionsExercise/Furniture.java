package RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        List<String> furnitureList = new ArrayList<>();
        //>>Sofa<<312.23!3
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]+)!(?<quantity>[0-9]+)";
        //String regex1 = ">>(?<furniture>\\w+)<<(?<price>\\d+.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        double sum = 0.0;
        while (!input.equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String furnitureName = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitureList.add(furnitureName);

                double total = price * quantity;

                sum += total;
            }


            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");

        for (String furniture : furnitureList) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
