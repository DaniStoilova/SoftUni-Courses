package BasicSyntaxConditionalStatementsAndLoopsExersises;

        import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightSabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes  = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());



        double sumLight = Math.ceil(countOfStudents + 0.10 * countOfStudents) * priceOfLightSabers;

        double sumRobes = priceOfRobes * countOfStudents;


        double sumBelts = (countOfStudents - countOfStudents/6) * priceOfBelts;

        double total = sumLight + sumRobes + sumBelts;


        if (amountOfMoney <= total){
            System.out.printf("George Lucas will need %.2flv more.", Math.abs(amountOfMoney - total));
        }else{
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        }

    }
}
