package exam;

import java.util.Scanner;

public class EasterTrip {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        String date = scanner.nextLine();
        int countNight = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (destination.equals("France")){
            if (date.equals("21-23")){
                price = 30;
            }else if (date.equals("24-27")){
                price = 35;
            }else if(date.equals("28-31")){
                price = 40;
            }
        }else if (destination.equals("Italy")){
            if (date.equals("21-23")){
                price = 28;
            }else if (date.equals("24-27")){
                price = 32;
            }else if(date.equals("28-31")){
                price = 39;
            }

        }else if (destination.equals("Germany")){
            if (date.equals("21-23")){
                price = 32;
            }else if (date.equals("24-27")){
                price = 37;
            }else if(date.equals("28-31")){
                price = 43;
            }

        }
        double total = countNight * price;
        System.out.printf("Easter trip to %s : %.2f leva.",destination, total);

    }
}
