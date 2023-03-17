package exam;

import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int c1 =0;
        int c2 =0;
        int c3 =0;
        int c4 =0;

        for (int i=1; i <= n; i++) {
            String game = scanner.nextLine();
            if (game.equals("Hearthstone")) {
                c1 += 1;
            } else if (game.equals("Fornite")) {
                c2 += 1;
            } else if (game.equals("Overwatch")) {
                c3 += 1;
            } else if (!game.equals("Others")) {
                c4 += 1;
            }
        }
            System.out.printf("Hearthstone - %.2f%%%n", c1 * 1.0/n*100);
            System.out.printf("Fornite - %.2f%%%n", c2 * 1.0/n*100);
            System.out.printf("Overwatch - %.2f%%%n", c3 * 1.0/n*100);
            System.out.printf("Others - %.2f%%%n", c4*1.0/n*100);



    }
}
