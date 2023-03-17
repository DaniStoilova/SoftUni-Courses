package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> itemsMap = new LinkedHashMap<>();

        itemsMap.put("shards", 0);
        itemsMap.put("fragments", 0);
        itemsMap.put("motes", 0);

        Map<String, Integer> jungMap = new LinkedHashMap<>();

        boolean isWin = false;
        while (true) {
            String input = scanner.nextLine();
            String[] inputLine = input.split(" ");

            for (int i = 0; i <= inputLine.length - 1; i += 2) {
                int quality = Integer.parseInt(inputLine[i]);
                String material = inputLine[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int currentQuality = itemsMap.get(material);
                    itemsMap.put(material, currentQuality + quality);
                } else {
                    if (!jungMap.containsKey(material)) {
                        jungMap.put(material, quality);
                    } else {
                        int current = jungMap.get(material);
                        jungMap.put(material, current + quality);
                    }
                }
                if(itemsMap.get("shards") >= 250){
                    System.out.println("Shadowmourne obtained!");
                    itemsMap.put("shards",itemsMap.get("shards") -250);
                    isWin = true;
                    break;
                }else if(itemsMap.get("fragments") >= 250){
                    System.out.println("Valanyr obtained!");
                    itemsMap.put("fragments",itemsMap.get("fragments") -250);
                    isWin = true;
                    break;
                }else if (itemsMap.get("motes") >= 250){
                    System.out.println("Dragonwrath obtained!");
                    itemsMap.put("motes",itemsMap.get("motes") -250);
                    isWin = true;
                    break;
                }

            }
            if (isWin == true){
                break;
            }

        }
        for (Map.Entry<String, Integer> entry : itemsMap.entrySet()) {
                System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : jungMap.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }


    }
}
