package BasicSyntaxConditionalStatementsAndLoopsMoreExersises;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        if (first >= second && first >= third){
            if (second >= third){
                System.out.printf("%d%n%d%n%d%n",first,second,third);
            }else{
                System.out.printf("%d%n%d%n%d%n",first,third,second);
            }
        }else if (second >= first && second >= third){
            if (first >= third){
                System.out.printf("%d%n%d%n%d%n",second,first,third);
            }else{
                System.out.printf("%d%n%d%n%d%n",second,third,first);
            }
        }else if (third >= first && third >= second){
            if(first >= second){
                System.out.printf("%d%n%d%n%d%n",third,first,second);
            }else{
                System.out.printf("%d%n%d%n%d%n",third,second,first);
            }
        }
    }
}
