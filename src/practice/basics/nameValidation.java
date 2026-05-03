package practice.basics;

import java.util.Scanner;

public class nameValidation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String name=sc.next();
        if(name==null || name.trim().isEmpty()){
            System.out.println("please enter name");
        }
        else {
            System.out.println("it is a valid name");
        }
    }
}
