package practice.OOPS;

enum Cuisine{INDIAN,CHINESE,ITALINE,THAI,OTHER}
class Restaurant{
    private String name;
    private Cuisine cuisine;
    private double rating;

    public Restaurant(String name, Cuisine cuisine, double rating) {
        if(name==null|| name.trim().isEmpty()) throw new IllegalArgumentException("enter valid name");
        if(cuisine==null) throw new IllegalArgumentException("enter valid cuisine");
        if(rating<0.0 || rating>5.0) throw new IllegalArgumentException("rating must be between 0 and 5");

        this.name = name.trim();
        this.cuisine = cuisine;
        this.rating = Math.round(rating*10.0)/10.0;
    }

    public String getName() {
        return name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "%s cuisine %s have rating of %.1f".formatted(name,cuisine,rating);
    }
}
public class RestaurantForFoodDeliveryAPP {
    public static void main(String[] args) {
    Restaurant r= new Restaurant("indian Tadka",Cuisine.INDIAN,2.1);
        System.out.println(r);
    }
}
