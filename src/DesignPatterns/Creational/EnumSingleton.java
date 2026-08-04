package DesignPatterns.Creational;

enum DatabaseConnection {
    INSTANCE;

    public void connect() {
        System.out.println("connected to DB");
    }
}

public class EnumSingleton {
    public static void main(String[] args) {

        DatabaseConnection db1 = DatabaseConnection.INSTANCE;
        DatabaseConnection db2 = DatabaseConnection.INSTANCE;

        db1.connect();

        System.out.println(db1 == db2);   // true
    }

}
