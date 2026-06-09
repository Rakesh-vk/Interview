package collections.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{
    int empid;
     String name;

    public Employee(int empid, String name) {
        this.empid = empid;
        this.name = name;
    }


    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        if(o==null){
            throw new NullPointerException("cannot compare with null");
        }
        return Integer.compare(this.empid,o.empid);
    }
}


public class ComparableImpl {
    public static void main(String[] args) {
        List<Employee> obj = new ArrayList<>();
        obj.add(new Employee(1,"qaz"));
        obj.add(new Employee(4,"aaa"));
        obj.add(new Employee(3,"qwe"));

        Collections.sort(obj);
        for(Employee e:obj){
            System.out.println(e.empid+" "+e.name);
        }

    }
}
