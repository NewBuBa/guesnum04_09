package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {
    static Random randm = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> result = new ArrayList();

    public static void main(String[] args) {


        String answer;
        do {

            System.out.print("Enter name: ");
            String userName = scan.next();
            long t1 = System.currentTimeMillis();
            int mynum = randm.nextInt(100);

            System.out.println(mynum);
            boolean userlost = true;
            for (int i = 0; i < 10; i++) {
                int scanNum = askNum();
                if (scanNum > mynum) {
                    System.out.println("Моё число больше!");
                } else if (scanNum < mynum) {
                    System.out.println("Моё число меньше!");
                } else if (scanNum == mynum) {
                    System.out.println("Оба числа равны!");
                    userlost = false;
                    GameResult r = new GameResult();
                    r.name = userName;
                    r.tries = i + 1;
                    result.add(r);
                    long t2 = System.currentTimeMillis();
                    long time1 = (t2 - t1) / 1000;
                    r.time = time1;
                    break;
                }
            }
            if (userlost == true) {
                System.out.println("You lost");
            }
            System.out.println("Play again?");
            answer = askYN();

        }

        while (answer.equals("y"));

        showResult();
        saveResult();
        System.out.println("Bye");
    }

    private static void showResult() {
    }

    private static void saveResult() {
        File file = new File("top_score.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            //  out.println();
            for (GameResult r : result) {
                out.printf("%s %d %d\n",  r.name, r.tries, r.time);

            }

        } catch (IOException e) {
            System.out.println("Cannot save to file");
        }
    }

    private static void showresult() {
        for (GameResult r : result) {
          //  System.out.println(r.name + " tries=" + r.tries + "  time=" + r.time + " sec");
          //  System.out.printf("%s %d %dsec\n",  r.name, r.tries, r.time / 1000);
            System.out.printf("%s - %d - %.2fsec\n",  r.name, r.tries, r.time / 1000);
        }
    }

    static String askYN() {
        String answer;
        do {
            answer = scan.next();
            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("You can enter only y or no");

            } else {
                return answer;
            }
        }
        while (true);

    }

    static int askNum() {
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException a) {
                System.out.println("This is not number");
                scan.next();
                continue;
            }
            if (answer < 0) {
                System.out.println("Number less then 0");
            } else if (answer > 100) {
                System.out.println("Number more then 100");

            } else {
                return answer;
            }
        }
        while (true);
    }


    private static void println() {
    }
}