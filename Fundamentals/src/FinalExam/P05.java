package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            StringBuilder password = new StringBuilder(scanner.nextLine());

            String line = scanner.nextLine();

            while (!"Complete".equals(line)) {
                String[] command = line.split("\\s+");
                switch (command[0]) {
                    case "Make":
                        int index = Integer.parseInt(command[2]);
                        String current = String.valueOf(password.charAt(index));
                        if (command[1].equals("Upper")) {
                            String changed = current.toUpperCase();
                            password.replace(index, index + 1, changed);
                        } else {
                            String changed = current.toLowerCase();
                            password.replace(index, index + 1, changed);
                        }
                        System.out.println(password);
                        break;
                    case "Insert":
                        int index1 = Integer.parseInt(command[1]);
                        String currentChar = String.valueOf(command[2]);
                        if (isValid(password, index1)) {
                            password.insert(index1, currentChar);
                            System.out.println(password);
                        }
                        break;
                    case "Replace":
                        String searchedChar = String.valueOf(command[1]);
                        if (password.toString().contains(searchedChar)) {
                            int asciiValue = searchedChar.charAt(0);
                            int addValue = Integer.parseInt(command[2]);
                            char toReplace = (char) (asciiValue + addValue);
                            String updatedPass = password.toString().replace(searchedChar.charAt(0), toReplace);
                            System.out.println(updatedPass);
                            password.setLength(0);
                            password.append(updatedPass);
                        }
                        break;
                    case "Validation":
                        if (password.length() < 8) {
                            System.out.println("Password must be at least 8 characters long!");
                        }
                        Matcher matcher = Pattern.compile("\\W").matcher(password);
                        if (matcher.find()) {
                            System.out.println("Password must consist only of letters, digits and _!");
                        }
                        if (!isThereCap(password)) {
                            System.out.println("Password must consist at least one uppercase letter!");
                        }
                        if (!isThereLow(password)) {
                            System.out.println("Password must consist at least one lowercase letter!");
                        }
                        if (!isThereDigit(password)) {
                            System.out.println("Password must consist at least one digit!");
                        }
                        break;
                    default:
                        break;
                }
                line = scanner.nextLine();
            }
        }

        private static boolean isThereDigit(StringBuilder password) {
            String pass = password.toString();
            for (char c : pass.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isThereCap(StringBuilder password) {
            String pass = password.toString();
            for (char c : pass.toCharArray()) {
                if (c > 64 && c < 90) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isThereLow(StringBuilder password) {
            String pass = password.toString();
            for (char c : pass.toCharArray()) {
                if (c > 96 && c < 123) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isValid(StringBuilder input, int index1) {
            return index1 >= 0 && index1 <= input.length() - 1;
        }
    }


