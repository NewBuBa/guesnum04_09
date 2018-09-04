package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random randm = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String answer;
        int scanNum = 0;
        do {
            int mynum = randm.nextInt(100);
            System.out.println(mynum);
            boolean userLost = true;
            for (int i = 0; i < 10; i++) {
                scanNum = scan.nextInt();

                if (scanNum > mynum) {
                    System.out.println("Моё число больше!");
                } else if (scanNum < mynum) {
                    System.out.println("Моё число меньше!");
                } else if (scanNum == mynum) {
                    System.out.println("Оба числа равны!");
                    break;
                }
            }
//            if (userLost == true) {
////                System.out.println("test 2");
////            }
            System.out.println("YES / NO");
            answer = scan.next();
            answer = ASK ();
        } while (answer.equals("Y"));
        System.out.println("Bay");
    }

    static String ASK() {
        String answer;
        do {


            answer = scan.next();
        } while (!ASK().equals("y") && (!answer.equals("n")));
        return answer;

    }

}


