package practice.OOPS;

import java.math.BigDecimal;
import java.util.Objects;

class Passenger{
    private final String name;
    private final String contact;

    public Passenger(String name, String contact) {
        if(name==null || name.trim().isEmpty()) throw new IllegalArgumentException("Passenger name is required");

        this.name = name;
        this.contact = (contact==null) ? "":contact.trim();

    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
    public String toString(){
        return "%s  -  %s".formatted(name,contact);
    }
}
class Ticket{
    private String seatNo;
    private Passenger passenger;
    private final BigDecimal fare;

    public Ticket(BigDecimal fare, Passenger passenger, String seatNo) {
        if(seatNo== null || seatNo.trim().isEmpty())throw new IllegalArgumentException("enter valid seat number");
        if(passenger==null) throw new IllegalArgumentException("Passenger is required");
        if(fare == null || fare.signum()<0) throw  new IllegalArgumentException("invalid fare");
        this.fare = fare;
        this.passenger = passenger;
        this.seatNo = seatNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public BigDecimal getFare() {
        return fare;
    }
    public String toString(){
        return "%s | %s | %.1f".formatted(seatNo,passenger.getName(),fare);
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Ticket t)) return false;
        return Objects.equals(seatNo,t.seatNo) && Objects.equals(passenger.getName(),t.passenger.getName());

    }
    public int hashCode(){
        return  Objects.hash(seatNo,passenger.getName());
    }
}

public class TicketObjectInBookingSystem {
    public static void main(String[] args) {
        Passenger p = new Passenger("Rakesh","1211212");
        System.out.println(p);
        Ticket t= new Ticket(new BigDecimal(12.11),p,"12");
        System.out.println(t);
    }
}
