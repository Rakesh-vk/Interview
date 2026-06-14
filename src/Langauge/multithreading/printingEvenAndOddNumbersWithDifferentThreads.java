package Langauge.multithreading;

public class printingEvenAndOddNumbersWithDifferentThreads {
    public volatile int count=1;
    int limit=0;
    printingEvenAndOddNumbersWithDifferentThreads(int lim){
        this.limit=lim;
    }
    public synchronized void printEven(){
        while(count<=limit){
            if(count%2==0){
                System.out.println(Thread.currentThread().getName()+" "+count);
                count++;
                notifyAll();
            }
            else {
                try{
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  synchronized void printOdd(){
        while(count<=limit){
            if(count%2!=0){
                System.out.println(Thread.currentThread().getName()+" "+count);
                count++;
                notifyAll();
            }
            else {
                try{
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        printingEvenAndOddNumbersWithDifferentThreads obj = new printingEvenAndOddNumbersWithDifferentThreads(10);
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printOdd();
            }
        });
        t1.setName("odd");
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEven();
            }
        });
        t2.setName("even");

        t1.start();
        t2.start();

    }
}
