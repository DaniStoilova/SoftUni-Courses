import java.util.Scanner;

public class LiveDemo {
    public static void main(String[] args) {
        //prochitane vhod
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //preobrazuvane v chislo
        int USD = Integer.parseInt(input);
        //logika
        double LvOneUsd = 1.79549;
        double lv = USD * LvOneUsd;
        //printirane i formatirane
        System.out.println(lv);

    }




}
