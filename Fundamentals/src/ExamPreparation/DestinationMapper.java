package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(=|\\/)(?<destination>[A-Z][A-za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        int travelPoints = 0;
        List<String> destination= new ArrayList<>();
        while (matcher.find()){
            String location = matcher.group("destination");

            destination.add(location);

            travelPoints += location.length();


        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ",destination));
        System.out.printf("Travel Points: %d",travelPoints);

    }
}
