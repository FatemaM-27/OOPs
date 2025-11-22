package com.Day4.CW.Polymorphism;

class Employee{
    void calculateBonus(double salary){

    }
}
class Manager extends Employee{
    void calculateBonus(double salary){
        System.out.println(salary*0.3);
    }
}
class Intern extends Employee{
    void calculateBonus(double salary){
        System.out.println(salary*0.1);
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
//        Manager manager=new Manager();
//        Intern intern=new Intern();
        Employee manager=new Manager();
        Employee intern=new Intern();
        manager.calculateBonus(200000);
        intern.calculateBonus(25000);
    }
}