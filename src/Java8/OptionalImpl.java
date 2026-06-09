package Java8;
import java.util.Optional;
/*
Optional<T> is a container class introduced in Java 8 that may or may not hold a non-null value. It is designed to represent the absence of a value explicitly, instead of returning null and risking NullPointerException.
Optional<String> opt = Optional.ofNullable(getValue());

opt.isPresent()        // checks if value exists
opt.get()              // returns value, throws if empty ⚠️
opt.orElse("default")  // returns value or fallback
opt.orElseGet(() -> computeDefault())  // lazy fallback
opt.orElseThrow(() -> new RuntimeException()) // throw if empty
opt.map(String::toUpperCase)   // transform if present
opt.filter(s -> s.length() > 3) // filter condition
opt.ifPresent(System.out::println) // consume if present
*/
// Optional.of() - Throws NPE if null
// Optional.ofNullable() - Accepts null
// Optional.isEmpty() - Empty Optional
class Student{
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public Optional<String> getNameOptional(){
        return Optional.ofNullable(name);
    }
}

public class OptionalImpl {
    public static void main(String[] args) {
        Student s= new Student(null,1);
        Student s1= new Student("Rakesh",2);
        System.out.println(s.id);
        //Traditional way
        if(s!=null && s.name!=null)
        System.out.println(s.name.length());
        // using Optional class
        String name= s.getNameOptional().map(String::trim).map(String::toUpperCase).orElse("Default name");
        System.out.println(name);

        // will check if there is value or not and return true and false
        System.out.println("isPresent() : "+s.getNameOptional().isPresent());
        // will do following operation if there is a value
        s.getNameOptional().ifPresent(System.out::println);
        // orElse() return default value if there is no value
        System.out.println(s.getNameOptional().orElse("hello"));
        // orElseGet() same as orElse() but with lazy initialization
        System.out.println(s.getNameOptional().orElseGet(()->"Default value"));
        // orElseThrow() return value if present else throw exception
        //System.out.println(s.getNameOptional().orElseThrow(()-> new IllegalArgumentException("name can not be null")));
        // map()
        System.out.println(s.getNameOptional().map(String::toUpperCase));
        // flatmap()
        Optional<Student> student= Optional.of(new Student("Hello",3));
        Optional<Optional<String>> result = student.map(Student::getNameOptional);
        System.out.println(result);

        Optional<String> result1= student.flatMap(Student::getNameOptional);
        System.out.println(result1);

    }
}
