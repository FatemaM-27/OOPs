package com.Day2.HW.HW6;

public class PrintValues {
    public static void main(String[] args) {

        if(args.length==0){
            System.out.println("No values found");
        } else {
            for(int i=0;i<args.length;i++){
                System.out.println(args[i]);
                if(i<args.length-1){
                    System.out.println(",");
                }
            }
        }
    }
}
