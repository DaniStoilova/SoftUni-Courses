package exam;

import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
      String movie = scanner.nextLine();
      int countSeason = Integer.parseInt(scanner.nextLine());
      int countEpisode = Integer.parseInt(scanner.nextLine());
      double timeEpisodeWithout = Double.parseDouble(scanner.nextLine());

      double timeEpisode = timeEpisodeWithout * 0.2;
      double allTime = timeEpisodeWithout + timeEpisode;
      double time = countSeason * 10;
      double totalTime = Math.floor(allTime * countEpisode * countSeason + time);


      System.out.printf("Total time needed to watch the %s series is %.0f minutes.", movie, totalTime);


    }
}
