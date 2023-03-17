package exam;

import java.util.Scanner;

public class MovieDay {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int timePicture = Integer.parseInt(scanner.nextLine());
        int countScene = Integer.parseInt(scanner.nextLine());
        int timeScene = Integer.parseInt(scanner.nextLine());

        double timeMin = timePicture * 0.15;
        int allTimeScene = countScene * timeScene;
        double allTime = timeMin + allTimeScene;
        double diff = Math.abs(timePicture-allTime);

        if (allTime < timePicture){
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", diff);
        }else{
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", diff);
        }

    }
}
