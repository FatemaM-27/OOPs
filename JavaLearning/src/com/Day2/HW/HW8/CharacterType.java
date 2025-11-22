package com.Day2.HW.HW8;

public class CharacterType {
    public static void main(String[] args) {
    char ch= 'v';
    if ((ch>= 'a' && ch<='z')||(ch>='A' && ch<= 'Z')){
        System.out.print("Is a Alphabet");
    } else if (ch>='0' && ch<='9'){
        System.out.print("Is a Digit");
    } else {
        System.out.print("Is a Special Character");
    }
   }
}
