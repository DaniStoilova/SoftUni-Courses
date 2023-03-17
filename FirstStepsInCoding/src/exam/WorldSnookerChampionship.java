package exam;

import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String snooker= scanner.nextLine();
        String type= scanner.nextLine();
        int countTicket = Integer.parseInt(scanner.nextLine());
        String picture= scanner.nextLine();
        double price = 0;
        if (type.equals("Standard")){
            if (snooker.equals("Quarter final")){
                    price= 55.50;
            }else if(snooker.equals("Semi final")){
                price= 75.88;
            }else if(snooker.equals("Final")){
                price= 110.10;
            }

        }else if(type.equals("Premium")){
            if (snooker.equals("Quarter final")){
                price= 105.20;
            }else if(snooker.equals("Semi final")){
                price= 125.22;
            }else if(snooker.equals("Final")){
                price= 160.66;
            }

        }else if (type.equals("VIP")){
            if (snooker.equals("Quarter final")){
                price= 118.90;
            }else if(snooker.equals("Semi final")){
                price= 300.40;
            }else if(snooker.equals("Final")){
                price = 400;
            }

        }
        double total = countTicket * price;

        if (total > 4000){
            total = total * 0.75;
        }else if (total > 2500 && total <= 4000){
            total = total * 0.90;
            if (picture.equals("Y")){
                total = total + countTicket * 40;
            }else if(picture.equals("N")){

            }
        }
        System.out.printf("%.2f",total);
    }
}
