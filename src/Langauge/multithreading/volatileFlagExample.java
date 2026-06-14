package Langauge.multithreading;

// volatile only provides visibility
// volatile is particularly useful when we need to ensure visibility of a variable's updates across threads but do not require atomicity

public class volatileFlagExample{
    private volatile boolean running = true;
    public void stop(){
        running=false;
    }
    public void doWork(){
        System.out.println("the worker started working");
        while(running){

        }
        System.out.println("worker thread stopped");
    }
    public static void main(String[] args) {
        volatileFlagExample example= new volatileFlagExample();
        Thread workerThread =  new Thread(example::doWork);
        workerThread.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        example.stop();
        try{
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread completed");
    }
}

