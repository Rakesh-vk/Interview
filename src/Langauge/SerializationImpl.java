package Langauge;/*
it is the process of converting an object into format that can be saved to a file or sent over a network or stored in database later that object can be restored to its original state through deserialization

why we need serialization
 1. data persistence : you can save the object to file and retrieve them later
 2. Data Transmission : Object can be sent ove network between system or servers
 3. caching : Object can be cached in serialized form and load when needed

Use case
 1. Session management : Saving user sessions in web applications
 2. Distributed system : transmitting object between servers or systems
 3. Deep copying object : Serialization can be used to create a deep copy
 4. caching data : serialized data can be saved in cache like Redis for faster retrieval.


*/

import java.io.*;

class Player implements Serializable
{
    private static final long serialVersionUID = 1L;
    String name;
    int score;
    transient String password;
}
public class SerializationImpl {
    public static void main(String[] args) throws FileNotFoundException {
        Player player= new Player();
        player.name="Rakesh";
        player.password="Kuratti";
        player.score=100;

        // serialization
        try(FileOutputStream fileOut = new FileOutputStream("player.ser")){
            ObjectOutputStream out= new ObjectOutputStream(fileOut);
            out.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // deserialization
        try(FileInputStream fileIn = new FileInputStream("player.ser")){
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Player deObj=(Player) in.readObject();
            System.out.println(deObj.name);
            System.out.println(deObj.password);
            System.out.println(deObj.score);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
