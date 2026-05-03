package practice.basics;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of terms: ");
        int n=sc.nextInt();

        int a=0,b=1;
        System.out.println("Fibonacci sequence: ");
        for(int i=1;i<=n;i++){
            System.out.println(a+" ");
            int next=a+b;
            a=b;
            b= next;
        }
    }
}
