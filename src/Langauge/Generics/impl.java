package Langauge.Generics;

class generic<T>{
    private T t;
    public void set(T t){
        this.t=t;
    }
    public T get(){
        return t;
    }
}

public class impl {
    public static void main(String[] args) {
        generic obj = new generic();
        obj.set("hello");
        System.out.println(obj.get());
        obj.set(12);
        System.out.println(obj.get());
    }
}
