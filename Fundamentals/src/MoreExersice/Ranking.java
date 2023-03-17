package MoreExersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> map = new LinkedHashMap<>();

        Map<String, Integer> users = new LinkedHashMap<>();



        while (!input.equals("end of contests")) {
            String[] line = input.split(":");
            String contest = line[0];
            String passContest = line[1];


            map.put(contest, passContest);

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("end of submissions")) {
            String[] commandLine = command.split("=>");
            String contest = commandLine[0];
            String pass = commandLine[1];
            String username = commandLine[2];
            int point = Integer.parseInt(commandLine[3]);

            if (map.containsKey(contest)) {

                if (map.containsKey(pass)) {

                    Map<String, Integer> mapCourse = new LinkedHashMap<>();

                    mapCourse.put(contest,point);





                }

            }


            command = scanner.nextLine();
        }


    }
}
