package ExamPreparation;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 1; i <= count; i++) {
            String pieceData = scanner.nextLine();
            String[] piecePart = pieceData.split("\\|");
            String namePiece = piecePart[0];
            String composer = piecePart[1];
            String tone = piecePart[2];

            List<String> listInfo = new ArrayList<>();

            listInfo.add(composer);
            listInfo.add(tone);

            map.put(namePiece, listInfo);

        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {


            if (input.contains("Add")) {
                String name = input.split("\\|")[1];
                String composer = input.split("\\|")[2];
                String tone = input.split("\\|")[3];

                if (map.containsKey(name)) {
                    System.out.printf("%s is already in the collection!%n", name);
                } else {
                    List<String> info = new ArrayList<>();
                    info.add(composer);
                    info.add(tone);

                    map.put(name, info);
                    System.out.printf("%s by %s in %s added to the collection!%n", name, composer, tone);
                }

            } else if (input.contains("Remove")) {
                String pieceRemove = input.split("\\|")[1];

                if (map.containsKey(pieceRemove)) {
                    map.remove(pieceRemove);
                    System.out.printf("Successfully removed %s!%n", pieceRemove);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceRemove);
                }

            } else if (input.contains("ChangeKey")) {
                String pieceName = input.split("\\|")[1];
                String newTone = input.split("\\|")[2];

                if (!map.containsKey(pieceName)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                } else {
                    List<String> currentList = map.get(pieceName);
                    currentList.remove(1);
                    currentList.add(newTone);
                    map.put(pieceName, currentList);
                    System.out.printf("Changed the key of %s to %s!%n", pieceName, newTone);

                }


            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }


    }
}
