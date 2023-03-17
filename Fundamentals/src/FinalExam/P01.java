package FinalExam;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String input = scanner.nextLine();


        while (!input.equals("Complete")) {
            String[] command = input.split(" ");

            if (input.contains("Make Upper")) {
                int index = Integer.parseInt(command[2]);

                char text = password.charAt(index);

                password = password.replace(text, password.toString().toUpperCase().charAt(index));


                System.out.println(password);


            } else if (input.contains("Make Lower")) {
                int index = Integer.parseInt(command[2]);

                char text = password.charAt(index);

                password = password.replace(text, password.toString().toLowerCase().charAt(index));

                System.out.println(password);

            } else if (input.contains("Insert")) {
                int index = Integer.parseInt(command[1]);
                char symbol = command[2].charAt(0);

                if (index >= 0 && index <= password.length()) {
                    StringBuilder builder = new StringBuilder(password);

                    builder.insert(index, symbol);

                    password = builder.toString();

                    System.out.println(password);


                }

            } else if (input.contains("Replace")) {
                char symbol = command[1].charAt(0);
                int value = Integer.parseInt(command[2]);

                char newSymbol = (char) ((int) symbol + value);


                StringBuilder builder = new StringBuilder(password);


                password = builder.toString().replace(symbol, newSymbol);

                System.out.println(password);


            } else if (input.contains("Validation")) {

                if (password.length() >= 8) {

                } else {
                    System.out.println("Password must be at least 8 characters long!");

                }
                for (char symbol : password.toCharArray()) {
                    if (!Character.isLowerCase(symbol) &&
                            !Character.isUpperCase(symbol) && !Character.isDefined(symbol)) {
                        System.out.println("Password must consist only of letters, digits and _!");
                        break;
                    }
                }
                    for (char symbol : password.toCharArray()) {
                        if (!Character.isUpperCase(symbol)) {

                        }else{
                            System.out.println("Password must consist at least one uppercase letter!");

                        }
                    }
                        for (char symbol : password.toCharArray()) {
                            if (!Character.isLowerCase(symbol)) {
                                System.out.println("Password must consist at least one lowercase letter!");

                            }
                        }
                            for (char symbol : password.toCharArray()) {
                                if (!Character.isDigit(symbol)) {
                                    System.out.println("Password must consist at least one digit!");


                                }

                            }
                        }
            input = scanner.nextLine();
                    }

                }

            }

