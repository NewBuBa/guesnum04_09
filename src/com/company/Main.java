package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {
    static Random randm = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList();

    public static void main(String[] args) {
        loudresult();

        saveresult();
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
                    results.add(r);
                    long t2 = System.currentTimeMillis();
                    long time1 = (t2 - t1) / 1000;
                    r.time = time1;
                    saveresult();
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

        showresult();

        System.out.println("Bye");
    }

    private static void loudresult() {
        File file = new File("top_result.txt");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNext()) {
                GameResult result = new GameResult();
                result.name = in.next();
                result.tries = in.nextInt();
                result.time = in.nextInt();
                results.add(result);

            }
        } catch (IOException e) {
            System.out.println("Cannot save to file");
        }
    }

    private static void saveresult() {
        File file = new File("top_result.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            for (GameResult r : results) {
                out.printf("%s %d %d\n", r.name, r.tries, r.time);
            }
        } catch (IOException e) {
            System.out.println("Cannot save to file");
        }
    }

//    private static void showresult() {
//        int count = 0;
//        for (GameResult r : results) {
//            System.out.printf("name- %s  tries- %d  sec- %d \n", r.name, r.tries, r.time);
//            count++;
//            if(count == 5){
//                break;
//
//}
//        }
//    }
//
//    private static void showresult() {
//        int a = Math.min(5, results.size());
//
//        for (int i = 0; i<a; i++) {
//            GameResult r = results.get(i);
//            System.out.printf("%s %d %d\n", r.name, r.tries, r.time);
//
//
//
//
//        }
//    }


    private static void showresult() {
        results.stream()
                .sorted(Comparator.<GameResult>comparingInt(r-> r.tries).thenComparingLong(r-> r.time))

                //     .filter(r-> r.name.equals("roma")) //фильтр по имени
                .limit(5)
                .forEach(r-> {
                    System.out.printf("%s %d %d\n", r.name, r.tries, r.time);
                });
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
}