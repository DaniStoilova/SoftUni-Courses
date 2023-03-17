package MethodsExersises;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        printVowelsCount(text);

    }
    private static void printVowelsCount(String text){
        int count = 0;

        for (int i = 0; i <= text.length() - 1 ; i++) {
           char currentSymbol = text.charAt(i);
            if(currentSymbol == 'a' || currentSymbol == 'e'|| currentSymbol == 'i'||
                    currentSymbol == 'o'|| currentSymbol == 'u'){
                count++;
            }
        }
        System.out.println(count);
    }
}
