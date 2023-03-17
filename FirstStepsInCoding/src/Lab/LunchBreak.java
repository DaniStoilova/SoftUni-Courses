package Lab;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int movieTime = Integer.parseInt(scanner.nextLine());
        int allRestTime= Integer.parseInt(scanner.nextLine());

        // time epizod - 60 ; time break - 96;

        double timeLunch =  allRestTime/8.0;
        double timeRest = allRestTime/4.0;

        double leftTime = (allRestTime-timeLunch-timeRest);
        double diff = Math.abs(leftTime-movieTime);


        if (leftTime >= movieTime){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", movie,Math.ceil(diff));
        }else{
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", movie, Math.ceil(diff));
        }

    }
}
