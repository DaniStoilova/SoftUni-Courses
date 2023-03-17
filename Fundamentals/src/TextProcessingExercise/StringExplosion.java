package TextProcessingExercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder text = new StringBuilder(input);

        int power = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (symbol == '>'){
                    int attackPower =Integer.parseInt(text.charAt(i + 1) + "");
                    power += attackPower;
            }else if (symbol != '>' && power > 0){
                text.deleteCharAt(i);
                power--;
                i--;
            }
        }
        System.out.println(text);
    }
}
