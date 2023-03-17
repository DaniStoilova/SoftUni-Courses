package newMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> item = Arrays
                .stream(scanner.nextLine().split(" \\| "))
                .collect(Collectors.toList());


        String input = scanner.nextLine();

        while (!input.equals("Stop!")) {
            String[] commandLine = input.split(" ");
            String line = commandLine[0];

            switch (line) {
                case "Join":
                    String genreJoin = commandLine[1];

                    if (!item.contains(genreJoin)) {

                        item.add(genreJoin);
                    }


                    break;
                case "Drop":
                    String genreDrop = commandLine[1];

                    if (item.contains(genreDrop)) {
                        item.remove(genreDrop);
                    }

                    break;
                case "Replace":
                    String oldGenre = commandLine[1];
                    int indexOld = item.indexOf(oldGenre);
                    String newGenre = commandLine[2];

                    if (item.contains(oldGenre) && !item.contains(newGenre)) {

                        item.remove(oldGenre);
                        item.add(indexOld, newGenre);

                    }


                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(commandLine[1]);
                    int indexGenre = Integer.parseInt(commandLine[2]);

                    if (index1 >= 0 && index1 <= item.size() - 1
                            && indexGenre >= 0 && indexGenre <= item.size() - 1) {
                        String element = item.get(index1);
                        String element1 = item.get(indexGenre);

                        item.set(indexGenre, element);
                        item.set(index1, element1);

                    }

                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println(String.join(" ", item));


    }
}
