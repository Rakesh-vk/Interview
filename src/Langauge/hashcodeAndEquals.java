package Langauge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

class Employees{
    int id;
    String name;
    int age;

    public Employees(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return id == employees.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class hashcodeAndEquals {
    public static void main(String[] args) {
        HashSet<Employee> set = new HashSet<>();

        set.add(new Employee("aa", "AAA", 20));
        set.add(new Employee("bb", "BBB", 30));

        System.out.println(set.size());
        System.out.println(set.toString());
    }
}
