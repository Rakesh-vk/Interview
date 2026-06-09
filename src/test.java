interface car{
    public void drive();
}
class BMW implements car{
    public void drive(){
        System.out.println("Drive in BMW");
    }
}
class skods implements car{
    @Override
    public void drive() {
        System.out.println("Drive in Skoda");
    }
}

public class test {
    public static void main(String[] args) {
        car cars = new BMW();
        cars.drive();
    }
}
