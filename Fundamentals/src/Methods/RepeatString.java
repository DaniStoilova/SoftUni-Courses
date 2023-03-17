package Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());


        System.out.println(repeat(input,n));


    }

    public static String repeat(String textToRepeat,int n){
        String output = "";
        for (int i = 0; i < n; i++) {
            output += textToRepeat;
        }
        return output;
    }
}
