/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2420;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

public class TowerOfHanoi {

    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();
    static Stack<Integer> s3 = new Stack<Integer>();

    public static void main(String[] args) {
        int numDisks = 4;
        boolean done = false;

        for (int i = numDisks; i > 0; i--) {
            s1.push(i);
        }

        Scanner scan = new Scanner(System.in);

        while (done != true) {
            //System.out.println(s1.toString() + "\n" + s2.toString() + "\n" + s3.toString() + "\n");
            System.out.println("1: A-B \n2: A-C \n3: B-A \n4: B-C \n5: C-A \n6: C-B \n");
            display();
            System.out.println("What move would you like to make (1-6)?");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    choice = 1;
                    movePeg(s1, s2);
                    break;
                case 2:
                    choice = 2;
                    movePeg(s1, s3);
                    break;
                case 3:
                    choice = 3;
                    movePeg(s2, s1);
                    break;
                case 4:
                    choice = 4;
                    movePeg(s2, s3);
                    break;
                case 5:
                    choice = 5;
                    movePeg(s3, s1);
                    break;
                case 6:
                    choice = 6;
                    movePeg(s3, s2);
                    break;
            }
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            done = true;
        }

    }

    public static void movePeg(Stack<Integer> from, Stack<Integer> to) {
        if (from.isEmpty()) {
            System.out.println("You cannot move disks from a peg that is empty!");
        } else if (to.isEmpty()) {
            to.push(from.pop());
        } else if (from.peek() > to.peek()) {
            System.out.println("You cannot move a larger disk onto a smaller one!");
        } else {
            to.push(from.pop());
        }
    }

    public static void display() {
        System.out.println(" A  |  B  |  C ");
        System.out.println("----------------");
        String t1 = String.valueOf(s1.toString()), t2 = String.valueOf(s2.toString()),
                t3 = String.valueOf(s3.toString());
        for (int d = 0; d < 4 + 4; d++) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                if (d % 2 == 0) {
                    d1 = String.valueOf(t1.charAt(d));
                } else {
                    continue;
                }
            } catch (Exception e) {
                d1 = " ";
            }
            try {
                d2 = String.valueOf(t2.charAt(d));
            } catch (Exception e) {
                d2 = " ";
            }
            try {
                d3 = String.valueOf(t3.charAt(d));
            } catch (Exception e) {
                d3 = " ";
            }
            System.out.println(" " + d1 + "  |  " + d2 + "  |  " + d3);

        }
        System.out.println();

    }
}
