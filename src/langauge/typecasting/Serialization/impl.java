package langauge.typecasting.Serialization;

import java.io.*;

class User implements Serializable{

     String name;
     transient int age;
    User(String _name,int _age){
        this.name=_name;
        this.age=_age;
    }
}
public class impl {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User obj = new User("Rakesh",1);
        System.out.println("serialization start");
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("User.ser"));
        out.writeObject(obj);
        out.close();
        System.out.println("serialization completed");

        System.out.println("Deserialization start");
        ObjectInputStream in= new ObjectInputStream(new FileInputStream("User.ser"));
        User o = (User) in.readObject();
        System.out.println(o.age);
        System.out.println(o.name);
        in.close();
        System.out.println("Deserialization completed");
    }
}
