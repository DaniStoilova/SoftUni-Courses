package exam;

import java.util.Scanner;

public class MovieRatings {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

    int countMovie = Integer.parseInt(scanner.nextLine());

    double max =Double.MIN_VALUE;
    String maxMovie = "";
    double min =Double.MAX_VALUE;
    String minMovie = "";
    double allRating = 0;

    for (int i=1; i <= countMovie; i++){
        String movie = scanner.nextLine();
        double rating = Double.parseDouble(scanner.nextLine());

        if(max < rating){
            max = rating;
            maxMovie = movie;
        }
        if (min > rating){
            min = rating;
            minMovie = movie;
        }

        allRating += rating;

    }
        double averageRating = allRating/countMovie;
    System.out.printf("%s is with highest rating: %.1f%n",maxMovie,max);
    System.out.printf("%s is with lowest rating: %.1f%n",minMovie,min);
    System.out.printf("Average rating: %.1f",averageRating);
    }
}
