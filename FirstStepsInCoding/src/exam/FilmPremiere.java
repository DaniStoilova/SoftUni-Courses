package exam;

import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String project = scanner.nextLine();
        String pack = scanner.nextLine();
        int countTicket = Integer.parseInt(scanner.nextLine());

        double price = 0.0;
        if (project.equals("John Wick")){
            if (pack.equals("Drink")){
                    price = 12;
            }else if(pack.equals("Popcorn")){
                price = 15;
            }else if (pack.equals("Menu")){
                price = 19;
            }

        }else if(project.equals("Star Wars")){
            if (pack.equals("Drink")){
                price = 18;
            }else if(pack.equals("Popcorn")){
                price = 25;
            }else if (pack.equals("Menu")){
                price = 30;
            }
            if (countTicket >= 4){
                price = price * 0.70;
            }

        }else if(project.equals("Jumanji")){
            if (pack.equals("Drink")){
                price = 9;
            }else if(pack.equals("Popcorn")){
                price = 11;
            }else if (pack.equals("Menu")){
                price = 14;
            }
            if (countTicket == 2){
                price = price * 0.85;
            }
        }
            double totalPrice = price * countTicket;
            System.out.printf("Your bill is %.2f leva.",totalPrice);

    }
}
