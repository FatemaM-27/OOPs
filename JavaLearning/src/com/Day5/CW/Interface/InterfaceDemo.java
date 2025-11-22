package com.Day5.CW.Interface;

interface Payable{
    void generatePayslip();

}
class Contractor implements Payable{
    public void generatePayslip(){
        System.out.println("Contractor pay is on day basis");
    }
}

class FullTimeEmployee implements Payable{
    @Override
    public void generatePayslip() {
        System.out.println("Full Time Employee salary will be on month basis");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {

    }
}