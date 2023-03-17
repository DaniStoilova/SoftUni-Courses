package exam;

import java.util.Scanner;

public class OscarsWeekInCinema {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        String type = scanner.nextLine();
        int countTicket = Integer.parseInt(scanner.nextLine());
        double price = 0;
        switch (movie){
            case "A Star Is Born":
                if (type.equals("normal")){
                    price = 7.50;
                }else if (type.equals("luxury")){
                    price = 10.50;
                }else if(type.equals("ultra luxury")){
                    price = 13.50;
            }
                break;
            case "Bohemian Rhapsody":
                if (type.equals("normal")){
                    price = 7.35;
                }else if (type.equals("luxury")){
                    price = 9.45;
                }else if(type.equals("ultra luxury")){
                    price = 12.75;
                }
                break;
            case "Green Book":
                if (type.equals("normal")){
                    price = 8.15;
                }else if (type.equals("luxury")){
                    price = 10.25;
                }else if(type.equals("ultra luxury")){
                    price = 13.25;
                }
                break;
            case "The Favourite":
                if (type.equals("normal")){
                    price = 8.75;
                }else if (type.equals("luxury")){
                    price = 11.55;
                }else if(type.equals("ultra luxury")){
                    price = 13.95;
                }
                break;
        }

        double total = price * countTicket;
        System.out.printf("%s -> %.2f lv.", movie, total);

    }
}
