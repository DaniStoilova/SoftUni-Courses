package ExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String regex = "(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 1; i <= n; i++) {
            String barcode = scanner.nextLine();

            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {

                String digit = barcode;

                String numbers = "";
                for (char c : digit.toCharArray()) {
                    if (Character.isDigit(c)) {

                        numbers += c;
                    }
                }

                if (numbers.isEmpty()) {
                    System.out.println("Product group: 00");

                } else {
                    System.out.printf("Product group: %s%n", numbers);
                }
            } else if (!matcher.find()) {
                System.out.println("Invalid barcode");


            }
        }

    }
}


