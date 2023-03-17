package WhileLoop;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());


        int boxVolume = width * length * high;
        int box = 0;

        while (boxVolume > 0){
            String input = scanner.nextLine();
            if (input.equals("Done")){
                break;
            }
            int countBox = Integer.parseInt(input);
            boxVolume -= countBox;

        }
        if(boxVolume > 0) {
            System.out.printf("%d Cubic meters left.", boxVolume);
        }else{
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(boxVolume));
        }
    }

}
