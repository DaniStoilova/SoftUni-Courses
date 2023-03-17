package Lab;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine()); //11
        int minutes = Integer.parseInt(scanner.nextLine()); //8 + 15 = 23


        int allMinutes = (hour * 60) + minutes + 15;
        int newHour = allMinutes/60;
        int newMin = allMinutes % 60;
            if (newHour > 23) {
                newHour = 0;
            System.out.printf("%d:%02d",newHour, newMin);
            }else{
                    System.out.printf("%d:%02d", newHour, newMin);
                }

    }


}
