import java.util.TreeSet;

public class Interview {
    public static void main(String[] args) {

        TreeSet<Employee> tset = new TreeSet<>();

        tset.add(new Employee(1, "AAA", 20));
        tset.add(new Employee(2, "BBB", 30));
        tset.add(new Employee(3, "CCC", 40));

        for (Employee e : tset) {
            System.out.println(e);
        }
    }
}

class Employee  implements Comparable<Employee>{

    int id;
    String name;
    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }



    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age + '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id,o.id);
    }
}