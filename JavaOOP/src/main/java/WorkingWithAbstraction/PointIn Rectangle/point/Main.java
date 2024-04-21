import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] coordinate = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point A = new Point(coordinate[0],coordinate[1]);
        Point C = new Point(coordinate[2],coordinate[3]);

        Rectangle rectangle = new Rectangle(A,C);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            int [] points = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point x = new Point(points[0],points[1]);
            boolean isInside = rectangle.contains(x);

            System.out.println(isInside);

        }
    }
}
