package practice.OOPS;

import java.util.UUID;

class Shipment{
    private String trackingId;
    private String recipient;

    public Shipment() {
        this.trackingId= UUID.randomUUID().toString();
        this.recipient="unknown";
    }

    public Shipment(String trackingId, String recipient) {
        this.trackingId = (trackingId== null|| trackingId.isBlank())? UUID.randomUUID().toString():trackingId.trim();
        this.recipient = (recipient==null || recipient.isBlank())? "unknown":recipient.trim();
    }
    public String toString(){
        return "Shipment[Recipient : "+recipient+" trackingID : "+trackingId;
    }
}

public class CourierSystem {
    public static void main(String[] args) {
Shipment s1= new Shipment();
        Shipment s2= new Shipment("Rakesh",null);
        System.out.println(s1);
        System.out.println(s2);
    }
}
