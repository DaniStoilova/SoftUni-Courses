package newMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String inputLine = scanner.nextLine();
        int countBlacklist = 0;
        int countLost = 0;
        String element = "";
        while (!inputLine.equals("Report")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Blacklist":
                    String name = commandLine[1];
                    if (namesList.contains(name)) {
                       int index = namesList.indexOf(name);
                       element = "Blacklisted";
                        //namesList.set(index,"Blacklist");
                        namesList.set(index,element);
                        System.out.printf("%s was blacklisted.%n", name);
                        countBlacklist++;
                    } else {

                        System.out.printf("%s was not found.%n", name);
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(commandLine[1]);
                    String lostName = namesList.get(index);
                    String elementLost = "Lost";

                    if (index >= 0 && index <= namesList.size() - 1 && !namesList.contains(element) && !namesList.contains(elementLost) ) {

                        System.out.printf("%s was lost due to an error.%n", lostName);

                        namesList.set(index,elementLost);
                        countLost++;
                    }else{



                    }


                    break;
                case "Change":
                    int indexChange = Integer.parseInt(commandLine[1]);
                    String newName = commandLine[2];
                    if (indexChange >= 0 && indexChange <= namesList.size() - 1){

                            String currentName = namesList.get(indexChange);
                            namesList.set(indexChange,newName);
                            System.out.printf("%s changed his username to %s.%n",currentName,newName);
                        }


                    break;

            }

            inputLine = scanner.nextLine();
        }

        System.out.printf("Blacklisted names: %d%n",countBlacklist);
        System.out.printf("Lost names: %d%n",countLost);

        for (String item:namesList) {
            System.out.print(item + " ");
        }

    }
}
