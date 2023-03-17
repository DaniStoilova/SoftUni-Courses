package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collectionList = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Craft!")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Collect":
                    String itemCollect = commandLine[2];
                    if (!collectionList.contains(itemCollect)) {
                        collectionList.add(itemCollect);
                    }
                    break;
                case "Drop":
                    String itemDrop = commandLine[2];
                    if (collectionList.contains(itemDrop)) {
                        collectionList.remove(itemDrop);
                    }
                    break;
                case "Combine":
                    String combineItem = commandLine[3];
                    String[] combine = commandLine[3].split("\\:");
                    String oldItem = combine[0];
                    String newItem = combine[1];
                    if (collectionList.contains(oldItem)) {

                        int index = (collectionList.indexOf(oldItem));
                        collectionList.add(index + 1, newItem);


                    }
                    break;
                case "Renew":
                    String itemRenew = commandLine[2];
                    if (collectionList.contains(itemRenew)) {
                        collectionList.remove(itemRenew);
                        collectionList.add(collectionList.size(), itemRenew);
                    }
                    break;
            }


            inputLine = scanner.nextLine();
        }


        System.out.println(String.join(", ", collectionList));


    }
}
