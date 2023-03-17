package exam;

import java.util.Scanner;

public class EasterEggs {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        int r =0;
        int o =0;
        int b =0;
        int g =0;
        int max = Integer.MIN_VALUE;
        String colorEggs = "";
        for (int i=1; i<=count; i++){
            String color = scanner.nextLine();
            switch (color){
                case "red":
                    r++;
                    break;
                case "orange":
                    o++;
                    break;
                case "blue":
                    b++;
                    break;
                case "green":
                    g++;
                    break;
            }
        }
        if (max <= r){
            max = r;
            colorEggs = "red";
        }
        if (max <= o){
            max = o;
            colorEggs = "orange";
        }
        if (max <= b){
            max = b;
            colorEggs = "blue";
        }
        if (max <= g){
            max = g;
            colorEggs = "green";
        }



        System.out.printf("Red eggs: %d%n",r);
        System.out.printf("Orange eggs: %d%n",o);
        System.out.printf("Blue eggs: %d%n",b);
        System.out.printf("Green eggs: %d%n",g);

        System.out.printf("Max eggs: %d -> %s",max, colorEggs);

    }
}
