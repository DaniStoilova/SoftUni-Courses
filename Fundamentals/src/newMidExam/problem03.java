package newMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneList = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());


        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);

            switch (command){
                case "Add":
                    String element = commandLine.get(2);
                    if (!phoneList.contains(element)){
                        phoneList.add(element);
                    }

                    break;
                case"Remove":
                    String elementRemove = commandLine.get(2);
                    if (phoneList.contains(elementRemove)){
                        phoneList.remove(elementRemove);
                    }

                    break;
                case "Bonus":
                  String []line = commandLine.get(3).split("\\:");
                  String oldItem = line[0];
                  String newItem = line[1];
                  if (phoneList.contains(oldItem)){
                      int index = (phoneList.indexOf(oldItem));
                      int newIndex = index + 1;
                      phoneList.add(newIndex, newItem);
                  }

                    break;
                case "Last":
                    String nameLast = commandLine.get(2);
                    if (phoneList.contains(nameLast)){
                        phoneList.remove(nameLast);
                        phoneList.add(phoneList.size(),nameLast);
                    }
                    break;

            }


            input = scanner.nextLine();

        }

        if(input.equals("End")){


            System.out.println(String.join(", ", phoneList));

        }
    }
}
