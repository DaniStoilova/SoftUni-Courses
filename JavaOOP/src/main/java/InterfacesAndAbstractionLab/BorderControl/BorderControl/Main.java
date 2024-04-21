package InterfacesAndAbstractionLab.BorderControl.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> list = new ArrayList<>();

        while (!input.equals("End")){
            String [] data = input.split("\\s+");

            Identifiable identifiable;

            if (data.length == 3){
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
              identifiable = new Citizen(name,age,id);
            }else{
                String id = data[0];
                String model = data[1];
                identifiable = new Robot(model,id);
            }


            list.add(identifiable);


            input = scanner.nextLine();
        }

        String fake = scanner.nextLine();



        list.stream().map(Identifiable::getId)
                .filter(id ->id.endsWith(fake))
                .forEach(System.out::println);






    }
}
