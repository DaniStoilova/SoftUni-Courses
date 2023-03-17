package Exam1;

import java.util.Scanner;

public class P03 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        char gender = scanner.nextLine().charAt(0);

        int age = 0;
        boolean isValid = true;
        if (gender == 'm'){
            if (type.equals("British Shorthair")){
                    age = 13;
            }else if(type.equals("Siamese")){
                age = 15;
            }else if(type.equals("Persian")){
                age = 14;
            }else if(type.equals("Ragdoll")){
                age = 16;
            }else if(type.equals("American Shorthair")){
                age = 12;
            }else if(type.equals("Siberian")){
                age = 11;
            }else{
                isValid = false;
            }


        }else if (gender == 'f'){
            if (type.equals("British Shorthair")){
                age = 14;
            }else if(type.equals("Siamese")){
                age = 16;
            }else if(type.equals("Persian")){
                age = 15;
            }else if(type.equals("Ragdoll")){
                age = 17;
            }else if(type.equals("American Shorthair")){
                age = 13;
            }else if(type.equals("Siberian")){
                age = 12;
            }else{
                isValid = false;
            }

        }else{
            isValid = false;
        }
        int total = age * 12;
        double catLife =Math.floor(total*1.0/6);

        if(!isValid){
            System.out.printf("%s is invalid cat!",type);
        }else {

            System.out.printf("%.0f cat months", catLife);


        }

    }
}
