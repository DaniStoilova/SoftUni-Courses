package MethodsExersises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String password = scanner.nextLine();

        boolean isValidLength = isValidLength(password);
        if(!isValidLength){
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean isValidContent = isValidContent(password);
        if(!isValidContent){
            System.out.println("Password must consist only of letters and digits");
        }
        boolean isValidCountDigit = isValidCountDigit(password);
        if(!isValidCountDigit){
            System.out.println("Password must have at least 2 digits");
        }
        if(isValidLength && isValidContent && isValidCountDigit){
            System.out.println("Password is valid");
        }
    }

    private static boolean isValidLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValidContent(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCountDigit(String password){
        int count = 0;
        for (char symbol : password.toCharArray()) {
            if(Character.isDigit(symbol)){
                count++;
            }
        }
        if (count >= 2){
            return true;
        }else{
            return false;
        }
}
}
