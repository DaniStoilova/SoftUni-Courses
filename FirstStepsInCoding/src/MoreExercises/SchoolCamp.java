package MoreExercises;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String group = scanner.nextLine();
        int countStudents = Integer.parseInt(scanner.nextLine());
        int countNight = Integer.parseInt(scanner.nextLine());

        double price = 0;
        String sport = "";

        if (season.equals("Winter")){
            if (group.equals("girls")){
               sport = "Gymnastics";
               price = 9.60;
            }else if (group.equals("boys")){
                sport = "Judo";
                price = 9.60;
            }else if (group.equals("mixed")){
                sport = "Ski";
                price = 10;
            }
            if (countStudents >= 10 && countStudents < 20){
                price = countStudents * price * countNight * 0.95;
            }else if( countStudents >= 20 && countStudents < 50){
                price = countStudents * price * countNight * 0.85;
            }else if(countStudents >= 50){
                price = countStudents * price * countNight * 0.50;
            }else{
                price = countStudents * price * countNight;
            }
        }else if (season.equals("Spring")){
            if (group.equals("girls")){
                sport = "Athletics";
                price = 7.20;
            }else if (group.equals("boys")){
                sport = "Tennis";
                price = 7.20;
            }else if (group.equals("mixed")){
                sport = "Cycling";
                price = 9.50;
            }
            if (countStudents >= 10 && countStudents < 20){
                price = countStudents * price * countNight * 0.95;
            }else if( countStudents >= 20 && countStudents < 50){
                price = countStudents * price * countNight * 0.85;
            }else if(countStudents >= 50){
                price = countStudents * price * countNight * 0.50;
            }else{
                price = countStudents * price * countNight;
            }
        }else if ( season.equals("Summer")){
            if (group.equals("girls")){
                sport = "Volleyball";
                price = 15;
            }else if (group.equals("boys")){
                sport = "Football";
                price = 15;
            }else if (group.equals("mixed")){
                sport = "Swimming";
                price = 10;
            }
            if (countStudents >= 10 && countStudents < 20){
                price = countStudents * price * countNight * 0.95;
            }else if( countStudents >= 20 && countStudents < 50){
                price = countStudents * price * countNight * 0.85;
            }else if(countStudents >= 50){
                price = countStudents * price * countNight * 0.50;
            }else{
                price = countStudents * price * countNight;
            }


        }

        System.out.printf("%s %.2f lv.", sport, price);

    }
}
