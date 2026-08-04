package collections.HashMap;

public class basics {
    public static void main(String[] args) {
        parent p = new parent();
        System.out.println(p.print());

    }
}
class parent{
     int print(){
         try{
             return 10;
         }
        finally{
             System.out.println("finally");
         }
    }
}

