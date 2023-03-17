package RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        List<String> race = Arrays
                .stream(name.split(", ")).collect(Collectors.toList());


        Map<String, Integer> mapDistance = new LinkedHashMap<>();

        for (String nameRace : race) {
            mapDistance.put(nameRace, 0);
        }
        String regexLetter = "[A-Za-z]+";

        Pattern patternLetter = Pattern.compile(regexLetter);

        String regexDigit = "[0-9]";

        Pattern patternDigit = Pattern.compile(regexDigit);


        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            StringBuilder nameBuilder = new StringBuilder();


            Matcher matcherLetter = patternLetter.matcher(input);

            while (matcherLetter.find()) {

                nameBuilder.append(matcherLetter.group());
            }
            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input);

            while (matcherDigit.find()) {

                distance += Integer.parseInt(matcherDigit.group());

            }

            String racerName = nameBuilder.toString();

            if (mapDistance.containsKey(racerName)) {
                int currentDistance = mapDistance.get(racerName);
                mapDistance.put(racerName, currentDistance + distance);
            }


            input = scanner.nextLine();
        }


//        System.out.printf("1st place: %s%n", nameFirstTree.get(0));
//        System.out.printf("2nd place: %s%n", nameFirstTree.get(1));
//        System.out.printf("3rd place: %s%n", nameFirstTree.get(2));



    }
}
