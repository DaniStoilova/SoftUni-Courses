package InterfacesAndAbstractionExercises.BirthdayCelebrations.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

       List<Birthable> list = new ArrayList<>();
        while (!input.equals("End")){
            String [] data = input.split(" ");
            String type = data[0];


            switch (type){
                case "Citizen":
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String birthDate = data[4];
                    Citizen citizen = new Citizen(name,age,id,birthDate);
                    list.add(citizen);
                    break;
                case "Robot":
                    String idRobot = data[1];
                    String model = data[2];
                    Robot robot = new Robot(idRobot,model);
                    break;
                case "Pet":
                    String namePet = data[1];
                    String birthDatePet = data[2];
                    Pet pet = new Pet(namePet,birthDatePet);
                   list.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        boolean isFound = false;
        for (Birthable birthable : list) {
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
                isFound = true;
            }
        }



        if (!isFound){
            System.out.println("<no output>");
        }



    }
}
