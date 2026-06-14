package Langauge.multithreading;

public class tickerBookingSystem {
    int tickets;
    tickerBookingSystem(int tickets){
        this.tickets=tickets;
    }
    public synchronized void bookTicket(int ticket){
        if(ticket<=tickets){
            System.out.println(Thread.currentThread().getName()+" booked "+ticket+" seats");
            tickets-=ticket;
        }
        else {
            System.out.println(Thread.currentThread().getName()+" booking failed");
        }
    }

    public static void main(String[] args) {
        tickerBookingSystem ticket= new tickerBookingSystem(5);

        Thread t1= new Thread(()->{ticket.bookTicket(2);});
        Thread t2= new Thread(()->{ticket.bookTicket(3);});
        Thread t3= new Thread(()->{ticket.bookTicket(2);});

        t1.setName("thread 1");
        t2.setName("thread 2");
        t3.setName("thread 3");

        t1.start();;
        t2.start();
        t3.start();
    }
}
