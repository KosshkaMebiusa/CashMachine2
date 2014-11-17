package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static int checkNumber (String message){
        int n;
        String s;
        while (true) {
            try {
                System.out.println(message);
                n = scan.nextInt();
                if (n <= 0){
                    System.out.println("Wrong value. Try again");
                }
                else { break;}
            } catch (Exception e) {
                s = scan.next();
                System.out.println("NAN. Try again");
            }
        }
        return n;
    }

    public static void main(String[] args) {
        // write your code here
        ArrayList<Integer> a = new ArrayList<Integer>();
        System.out.println("Enter value of coins");
        Scanner sc = new Scanner(System.in);
        String numberString;
        while (true) {
            try {
                numberString = sc.nextLine();
                for (String s : numberString.split(" ")) {
                    a.add(Integer.parseInt(s));
                }
                break;
            }
            catch (Exception e) {
                System.out.println("NAN. Try again");
                a.clear();
            }
        }

        CashMachine cash = new CashMachine(a.toArray(new Integer[a.size()]));
        int sum = checkNumber("Enter sum to change");
        cash.change(sum);
    }
}