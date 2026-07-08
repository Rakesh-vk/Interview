package interview;

// create class that will be singleton class

import Langauge.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Singleton {
    INSTANCE;
}



public class interview {
    public static void main(String[] args) {
        List<Employee> emp= new ArrayList<>();
        emp.add(new Employee("tom","it",100));
        emp.add(new Employee("jon","it",100));
        emp.add(new Employee("tom","HR",100));
        emp.add(new Employee("ram","HR",100));
        emp.add(new Employee("om","HR",100));
        emp.add(new Employee("Jonny","finance",100));

        emp.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ))
                .forEach((dept, names) -> System.out.println(dept + " -> " + names));

    }
}
