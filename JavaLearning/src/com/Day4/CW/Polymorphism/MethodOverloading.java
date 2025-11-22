package com.Day4.CW.Polymorphism;

class Calculator{
    public void add(int num1,int num2){
        System.out.println(num1+num2);
    }
    public void add(int num1,int num2,int num3){
        System.out.println(num1+num2+num3);
    }
    public void add(int num1,int num2,double num3){
        System.out.println(num1+num2+num3);
    }
}


public class MethodOverloading {
    public static void main(String[] args) {
        Calculator calc=new Calculator();
        calc.add(10,20,35.623);
    }
}
