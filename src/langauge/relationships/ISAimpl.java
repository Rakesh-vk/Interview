package langauge.relationships;

class Car{
    private String model;
    private String color;
    public String startEngine(){
        return "Engine started";
    }
    public String stopEnginer(){
        return "Engine stopped";
    }
    public String honk(){
        return "Beep";
    }
}

public class ISAimpl extends Car {
    public static void main(String[] args) {
        Car car= new ISAimpl();
        System.out.println(car.honk());
        System.out.println(car.startEngine());
        System.out.println(car.stopEnginer());

    }
}
