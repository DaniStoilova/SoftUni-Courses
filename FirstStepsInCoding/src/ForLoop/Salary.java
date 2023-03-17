package ForLoop;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());


        for (int i=1; i<=n; i++){
            if (salary > 0){
            String webSite = scanner.nextLine();
            switch (webSite) {
                case "Facebook":
                    salary = salary - 150;
                    break;
                case "Instagram":
                    salary = salary - 100;
                    break;
                case "Reddit":
                    salary = salary - 50;
                    break;
            }
            }
        }
                if (salary <= 0){
                    System.out.println("You have lost your salary.");
                }else{
                    System.out.printf("%d", salary);
                }
    }
}
