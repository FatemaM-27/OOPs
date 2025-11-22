package com.Day4.CW.Encapsulation;


class Student{
    private int rno;
    private String name;
    private int marks;
    public void setRno(int rno){
        this.rno=rno;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }
    public int getRno(){
        return rno;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }

}
public class EncapDemo {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setRno(101);
        s1.setName("Jannath");
        s1.setMarks(85);
//        System.out.println(s1.getRno()+" "+s1.getName()+" "+s1.getMarks());
        Student s2=new Student();
        s2.setRno(102);
        s2.setName("Ashwin");
        s2.setMarks(92);
//        System.out.println(s1.getRno()+" "+s1.getName()+" "+s1.getMarks());
        Student s3=new Student();
        s3.setRno(103);
        s3.setName("Dheena");
        s3.setMarks(65);
//        System.out.println(s1.getRno()+" "+s1.getName()+" "+s1.getMarks());
        Student[] students=new Student[3];
        students[0]=s1;
        students[1]=s2;
        students[2]=s3;
        int total=0;

        for(Student temp:students){
            System.out.println("Rno: "+temp.getRno()+"\nName: "+temp.getName()+"\nMarks: "+temp.getMarks());
            total+=temp.getMarks();
        }
        System.out.println(total);
        double average=(double)total/ students.length;
        System.out.println(average);
    }
}
