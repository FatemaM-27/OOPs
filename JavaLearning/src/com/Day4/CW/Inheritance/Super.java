package com.Day4.CW.Inheritance;

class Person{
    String name;
    public Person(String name){
        this.name=name;
    }
}
class Employee extends Person{
    int id;
    //    String name;
    public Employee(String name,int id){
        super(name);
        this.id=id;
    }
    public void display(){
        System.out.println(name+" "+id);
    }
}
public class Super {
    public static void main(String[] args) {
        Employee emp=new Employee("Jannath",101);
        emp.display();
    }
}