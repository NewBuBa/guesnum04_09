package com.company;

import java.util.*;

//public class Main {
//    static Random randm = new Random();
//    static Scanner scan = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        System.out.println("Do you want play? Write yes or no");


//        while (true) {
//
//            String word = scan.next();
//           if (Objects.equals( word, "yes")) {
//                int mynum = randm.nextInt(100);
//                System.out.println(mynum);
//
//                boolean userlost = true;
//                for (int i = 0; i < 10; i++) {
//                    int scanNum = scan.nextInt();
//
//                    if (scanNum > mynum) {
//                        System.out.println("Моё число больше!");
//                    } else if (scanNum < mynum) {
//                        System.out.println("Моё число меньше!");
//                    } else if (scanNum == mynum) {
//                        System.out.println("Оба числа равны!");
//                        userlost = false;
//break;
//                    }
//
//                }
//                if (userlost == true) {
//                    System.out.println("You lost");
//                }
//                System.out.println("Do you want play again? Write yes or no");
//            } else {
//                break;
//            }
//        }
//        System.out.println("Game is finished!");
//
//
//    }
//}
//



public class Main {
    static Random randm = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> result = new ArrayList();
    public static void main(String[] args) {


        String answer;
        do {
            System.out.print("Enter name: ");
            String userName = scan.next();

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
                    r.tries = i+1;
                    result.add(r);
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

    private static void showresult() {
        for(GameResult r : result){
            System.out.println(r.name + " result= " + r.tries );

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
            } catch (InputMismatchException a ){
                System.out.println("This is not number");
                scan.next();
                continue;
            }
            if (answer < 0 ) {
                System.out.println("Number less then 0");
            }
            else if (answer > 100){
                System.out.println("Number more then 100");

            } else{
                return answer;
            }
        }
        while(true);
    }
}