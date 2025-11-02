package com.Day1.HW.HW1;
import java.util.Scanner;

public class CommandLineArgs {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("please provide two arguments");
        } else {
            System.out.println(args[0] + " Technologies " + args[1]);
        }
    }
}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter company name: ");
//        String name = sc.nextLine();
//
//        System.out.println("Enter company location: ");
//        String loc = sc.nextLine();
//
//        System.out.println(name+ " Technologies " +loc);
//    }
//}

