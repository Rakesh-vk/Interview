

// create class that will be singleton class

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Singleton{
    private  Singleton obj;
    private Singleton(){
    }

    public synchronized  Singleton getObj(){
        if(obj!=null)
        {
            return obj;}

        return obj;
    }
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
                .collect(Collectors.groupingBy(Employee::getDept))
                .entrySet()
                .stream()
                .forEach(x->System.out.println(x.getKey()+" "+x.getValue()));


    }
}
