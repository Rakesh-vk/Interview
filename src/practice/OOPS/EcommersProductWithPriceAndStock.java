package practice.OOPS;

import java.math.BigDecimal;
import java.math.RoundingMode;

class product{
    private final String Description;
    private BigDecimal price;
   private int stock;

    public product(String description, BigDecimal price, int stock) {
        Description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getDescription() {
        return Description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    public synchronized void addStock(int newStock){
        if(newStock<0 ) throw new IllegalArgumentException("quantity can not be negative");
        stock+=newStock;
    }
    public synchronized void removeStock(int newStock){
        if(newStock<0 || newStock>stock) throw new IllegalArgumentException("invalid quantity");
        stock -=newStock;
    }
    public synchronized void updatePrice(BigDecimal newPrice){
        if(newPrice==null || newPrice.signum()<0) throw new IllegalArgumentException("Invalid Price");
        price = newPrice.setScale(2, RoundingMode.HALF_UP);
    }
    public String toString(){
        return " %s | %s | stock %d".formatted(getDescription(),getPrice(),getStock());
    }
}

public class EcommersProductWithPriceAndStock {
    public static void main(String[] args) {
        product p = new product("noise canceling headphone",new BigDecimal("1211.12"),12);
        System.out.println(p);
        p.addStock(2);
        System.out.println(p);
        p.removeStock(1);
        System.out.println(p);
        p.updatePrice(new BigDecimal(1.121));
        System.out.println(p);

    }
}












