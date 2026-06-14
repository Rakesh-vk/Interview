package Langauge.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceImpl {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
            int count=10;
        Runnable task=new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(i<=count){
                System.out.println(" hello "+Thread.currentThread().getName());
                i++;
                }
            }
        };

        executorService.submit(task);
        executorService.shutdown();
    }
}
