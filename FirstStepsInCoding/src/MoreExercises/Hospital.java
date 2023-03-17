package MoreExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        int treated = 0;
        int untreated = 0;
        for (int i=1; i <= period; i++){
            int countPatients = Integer.parseInt(scanner.nextLine());

            int onePatientPerDay = 7;
                    if (countPatients == onePatientPerDay){
                        treated = onePatientPerDay;
                        untreated = countPatients - treated;
                    }else if (countPatients > 7){
                        treated += onePatientPerDay;
                        untreated = countPatients - onePatientPerDay;
                    }
                        if (untreated > treated){
                            onePatientPerDay++;
                            treated = onePatientPerDay+1;
                            untreated = countPatients - treated;
                        }






        }














    }
}
