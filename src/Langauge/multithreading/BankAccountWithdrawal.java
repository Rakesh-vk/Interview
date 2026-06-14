package Langauge.multithreading;

public class BankAccountWithdrawal {
    int balance;
    BankAccountWithdrawal(int balance){
        this.balance=balance;
    }
    public synchronized void withdraw(int amount){
        if(amount<=balance){
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" withdraws "+ amount);
            System.out.println(
                    "Remaining balance : " + balance
            );
        }
        else {
            System.out.println(Thread.currentThread().getName()+" insufficient balance");
        }
    }
    public static void main(String[] args) {
        BankAccountWithdrawal atm = new BankAccountWithdrawal(1000);
        Thread t1= new Thread(()->{
            atm.withdraw(700);
        });

        Thread t2= new Thread(()->{
            atm.withdraw(500);
        });
        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}
