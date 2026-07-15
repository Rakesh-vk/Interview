package Multithreading;

public class printEvenAndOddUsing2Threads {
    int number=1;
    private final int max=10;

    public synchronized void printEven(){
        while(number < max){
            while(number %2!=0){
                try{
                    wait();
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
            if(number<=max){
                System.out.println("Even thread : "+number++);
            }
            notifyAll();
        }
    }
    public synchronized void printOdd(){
        while(number < max){
            while(number %2==0){
                try{
                    wait();
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
            if(number<=max){
                System.out.println("odd thread : "+number++);
            }
            notifyAll();
        }
    }


        public static void main(String[] args) {

            printEvenAndOddUsing2Threads printer = new printEvenAndOddUsing2Threads();

            Thread odd = new Thread(() -> printer.printOdd(), "Odd Thread");

            Thread even = new Thread(() -> printer.printEven(), "Even Thread");

            odd.start();
            even.start();
        }

}
