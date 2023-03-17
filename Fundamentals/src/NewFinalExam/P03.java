package NewFinalExam;

import java.util.*;
import java.util.stream.Collectors;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> mapBand = new LinkedHashMap<>();
        Map<String, Integer> mapPlay = new LinkedHashMap<>();
        int allTime = 0;
        while (!input.equals("Start!")) {
            String[] command = input.split("; ");
            String line = command[0];

            switch (line) {
                case "Add":
                    String bName = command[1];
                    String[] name = command[2].split(", ");

                    for (int i = 0; i < name.length; i++) {
                        String band = name[i];

                        if (!mapBand.containsKey(bName)) {

                            mapBand.put(bName, new ArrayList<>());

                            mapBand.get(bName).add(band);

                        } else if (mapBand.containsKey(bName) && !mapBand.get(bName).contains(band)) {
                            mapBand.get(bName).add(band);
                        }

                    }


                    break;


                case "Play":
                    String bandName = command[1];
                    int time = Integer.parseInt(command[2]);

                    if (!mapPlay.containsKey(bandName)) {

                        mapPlay.put(bandName, time);

                    } else {
                        int newTime = mapPlay.get(bandName);

                        mapPlay.put(bandName, time + newTime);
                    }
                    allTime += time;

                    break;


            }


            input = scanner.nextLine();
        }

        System.out.printf("Total time: %d%n", allTime);
        for (Map.Entry<String, Integer> entry : mapPlay.entrySet()) {

            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, List<String>> entry : mapBand.entrySet()) {

            String first = mapBand.keySet().stream().findFirst().get();
            List<String> list = mapBand.get(first);
            System.out.printf("%s%n", first);


            for (String s : list) {
                    System.out.printf("=> %s%n", s);

                }
           break;
            }

        }


    }

