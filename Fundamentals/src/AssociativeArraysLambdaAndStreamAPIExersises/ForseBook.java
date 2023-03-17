package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.*;

public class ForseBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Map<String, List<String>> bookMap = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String team = input.split(" \\| ")[0];
                String player = input.split(" \\| ")[1];

                if (!bookMap.containsKey(team)) {
                    bookMap.put(team, new ArrayList<>());

                }

                    boolean isExist = false;
                    for (List<String> list : bookMap.values()) {
                        if (list.contains(player)) {
                            isExist = true;
                        }
                    }


                    if (!isExist) {

                        bookMap.get(team).add(player);

                    }

            } else if (input.contains("->")) {
                String player = input.split(" -> ")[0];
                String team = input.split(" -> ")[1];

                bookMap.entrySet().forEach(entry -> entry.getValue().remove(player));

                if (bookMap.containsKey(team)) {
                    List<String> currentPlayer = bookMap.get(team);
                  currentPlayer.add(player);
                } else {
                    bookMap.put(team, new ArrayList<>());
                    bookMap.get(team).add(player);
                }
                System.out.printf("%s joins the %s side!%n", player, team);

            }

            input = scanner.nextLine();

        }
        bookMap.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                            System.out.printf("Side: %s, Members: %s%n", entry.getKey(), entry.getValue().size());
                            entry.getValue().forEach(player -> System.out.println("! " + player));
                        }

                );
    }
}
