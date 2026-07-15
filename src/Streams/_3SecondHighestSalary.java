package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary + '}';
    }
}
public class _3SecondHighestSalary {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rakesh", 80000),
                new Employee(2, "Amit", 90000),
                new Employee(3, "Rahul", 75000),
                new Employee(4, "Priya", 90000),
                new Employee(5, "Neha", 95000),
                new Employee(6, "Ankit", 85000),
                new Employee(7, "Kiran", 95000)
        );

        Optional<Double> first = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        first.ifPresent(System.out::println);
    }
}
