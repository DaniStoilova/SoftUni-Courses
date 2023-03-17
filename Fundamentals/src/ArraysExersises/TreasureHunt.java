package ArraysExersises;

import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] treasure = scanner.nextLine().split("\\|");

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Yohoho!")){
            String[] command = inputLine.split(" ");
                    switch (command[0]){
                        case "Loot":
                            for (int i = 1; i < command.length; i++) {

                                boolean alreadyContained = false;
                                for (int j = 0; j < treasure.length; j++) {
                                    if ( command[i].equals(treasure[j])){
                                      alreadyContained = true;
                                      break;
                                    }

                                }
                                if(!alreadyContained){
                                    String newChest = command[i] + " " + String.join(" ",treasure);

                                    treasure = newChest.split(" ");
                                }
                            }

                            break;
                        case "Drop":


                            int position = Integer.parseInt(command[1]);

                            if (position <= treasure.length -1 && position >= 0) {

                                String dropItem = treasure[position];

                                for (int i = position; i < treasure.length - 1; i++) {

                                    treasure[i] = treasure[i + 1];
                                }
                                treasure[treasure.length - 1] = dropItem;
                            }else{
                                break;
                            }

                            break;
                        case "Steal":
                            int numberOfStealingItems = Integer.parseInt(command[1]);
                            if(numberOfStealingItems >=0 && numberOfStealingItems < treasure.length){
                                for (int i = 0; i < numberOfStealingItems; i++) {
                                    System.out.print(treasure[treasure.length - numberOfStealingItems + i]);
                                    if ( i !=numberOfStealingItems -1){
                                        System.out.print(", ");
                                    }
                                }
                                String [] tempChest = new String[treasure.length - numberOfStealingItems];
                                for (int i = 0; i < tempChest.length; i++) {
                                    tempChest[i] = treasure[i];
                                }
                                treasure = tempChest;
                            }else if (numberOfStealingItems >= 0){
                                for (int i = 0; i < treasure.length; i++) {
                                    System.out.print(treasure[i]);
                                    if(i != treasure.length -1){
                                        System.out.print(", ");
                                    }
                                }
                                treasure = new String[0];

                            }
System.out.println();


                            break;
                    }

            inputLine = scanner.nextLine();
        }
        String treasureCount = String.join("",treasure);
        int charCount = 0;
        for (int i = 0; i < treasureCount.length(); i++) {
            charCount++;
        }
        double averageTreasure = (1.0 * charCount)/ treasure.length;
        if(charCount > 0){
            System.out.printf("Average treasure gain: %.2f pirate credits.",averageTreasure);
        }else{
            System.out.println("Failed treasure hunt.");
        }

    }
}
