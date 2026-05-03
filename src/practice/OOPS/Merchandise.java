package practice.OOPS;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Merchandise {
    private final String name;
    private final BigDecimal unitPrice;

    public Merchandise(String name, BigDecimal unitPrice) {
        if(name==null || name.trim().isEmpty()) throw new IllegalArgumentException("name is required");
        if(unitPrice==null || unitPrice.signum()<0) throw new IllegalArgumentException("the unit price must be >= 0");
        this.name = name;
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
    }
    public String toString(){
        return "title : "+name+" price : "+unitPrice;
    }

    public static void main(String[] args) {
        Merchandise m= new Merchandise("NoteBook",new BigDecimal(12.11));
        System.out.println(m);
    }
}
