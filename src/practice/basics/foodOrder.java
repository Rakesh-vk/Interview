package practice.basics;

import java.util.Scanner;

public class foodOrder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice: 1-pizza, 2-Burger, 3-salad");
        int choice= sc.nextInt();
        String meal;
        switch(choice){
            case 1: meal="pizza"; break;
            case 2: meal="burger"; break;
            case 3: meal="salad"; break;
            default :
                meal="Invalid selection";
        }
        System.out.println("you selected: "+meal);
    }
}
