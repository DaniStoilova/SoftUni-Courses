package NewFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(?<name>[A-Z][a-z]+\\s[A-Z][a-z]{3,})#+((?<job>([A-Za-z]+(&?)[A-Za-z]+(&?)[A-Za-z]+){1,3}))[0-9]{2}(?<company>[A-Z][A-Za-z0-9]+\\s[A-za-z]+\\.?)";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {

                String name = matcher.group("name");
                String job = matcher.group("job");
                String company = matcher.group("company");

                if (job.contains("&")) {
                    job = job.replace("&", " ");

                    System.out.printf("%s is at %s %s%n", name, job, company);

                } else {
                    System.out.printf("%s is at %s %s%n", name, job, company);


                }


            }
        }
    }
}
