package ArraysExersises;


import java.util.Scanner;

public class CommonElements1 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();

        String secondLine = scanner.nextLine();

        String[] firstArr = firstLine.split( " ");

        String[] secondArr = secondLine.split(" ");


        for (String elementsSecond : secondArr) {
            for (String elementsFirst : firstArr) {
                if (elementsSecond.equals(elementsFirst)){
                    System.out.print(elementsSecond + " ");
                }
            }
        }
    }
}
