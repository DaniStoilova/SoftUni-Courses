package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = hours * 60;

        int allMinutes = totalMinutes + minutes + 30;

        int newHours = allMinutes/60;
        int newMIn= allMinutes % 60;

        if (newHours > 23){
            newHours = 0;
            System.out.printf("%d:%02d", newHours,newMIn);
        }else if (newMIn < 10) {
            System.out.printf("%d:%02d", newHours, newMIn);
        }else{
            System.out.printf("%d:%d", newHours, newMIn);

        }

    }
}
