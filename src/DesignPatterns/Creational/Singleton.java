package DesignPatterns.Creational;

public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance= new Singleton();
                }

            }
        }
        return instance;
    }
}
class Test{
    public static void main(String[] args) {
        Singleton st= Singleton.getInstance();
        Singleton st1= Singleton.getInstance();
        System.out.println(st.toString());
        System.out.println(st==st1);
    }
}
