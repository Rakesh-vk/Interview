package langauge.relationships;

class Address
{
    private String street;
    private String city;
    private String state;
    private String zipcode;

    Address(String _street, String _city, String _state, String _zipcode){
        this.state=_state;
        this.city=_city;
        this.street=_street;
        this.zipcode=_zipcode;
    }
    public String getAddress(){
        return street+", "+city+", "+state+", "+zipcode+".";
    }
}
class Person{
    private String name;
    private Address address;

    Person(String _name,Address _address){
        this.name=_name;
        this.address=_address;
    }
    public String getPersonInfo(){
        return "Name: "+name+", Address: "+address.getAddress();
    }
}

public class HASAimpl {
    public static void main(String[] args) {
        Address newAddress = new Address("123 street","Bangalore","Karnataka","560043");
        Person person = new Person("Rakesh",newAddress);
        System.out.println(person.getPersonInfo());
    }

}
