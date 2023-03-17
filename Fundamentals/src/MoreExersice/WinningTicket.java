package MoreExersice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String[] text = scanner.nextLine().trim().split("(\\s*,\\s*)");

        String regex = "(?<ch>[@#$^]+)(?<match>\\1{6,})*(?<=.{10})\\2*";

        Pattern pattern = Pattern.compile(regex);


        for (String ticket : text) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                Matcher matcher = pattern.matcher(ticket);

                if (matcher.find()){

                    String ticketWin = matcher.group("ch");

                    if (ticketWin.length()/2 == 10){
                        int length = ticketWin.length()/2;
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n"
                        ,ticketWin,length,ticketWin.charAt(0));
                    }else {
                        System.out.printf("ticket \"%s\" - %d%s%n", ticket, ticketWin.length(), ticketWin.charAt(0));


                    }

                }else{
                    System.out.printf("ticket \"%s\" - no match%n",ticket);

                }




            }


        }


     }


}


