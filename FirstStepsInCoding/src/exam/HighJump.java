package exam;

import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int high = Integer.parseInt(scanner.nextLine());

        int jump = 0;
        int jumpFailed = 0;
        for (int j = high - 30; j <= high; j++) {
                   int h = 0;
            for (int i = 1; i <= high; i++) {
                int currentJump = Integer.parseInt(scanner.nextLine());
                if (currentJump > j) {
                    jump++;
                    j += 5;
                    if (currentJump >= high) {
                        break;
                    }

                } else if (j >= currentJump) {
                    jumpFailed++;



                }
                if (j == 235){
                        h++;
                }
            }
                if (h == 3) {
                    System.out.printf("Tihomir failed at %dcm after %d jumps.", high, jump + jumpFailed);
                } else {
                    System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", high, jump);


                }
            }
        }
    }
