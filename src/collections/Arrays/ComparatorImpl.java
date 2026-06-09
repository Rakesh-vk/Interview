package collections.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class student{
    int rno;
    String name;
    Integer marks;

    public student(int rno, String name, int marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "student{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public int getRno() {
        return rno;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

class StudentComparator implements Comparator<student> {
    public int compare(student s1, student s2){
        int nameCompare = s1.name.compareTo(s2.name);
        int marksCompare = s1.marks.compareTo(s2.marks);
        return (nameCompare==0)?marksCompare:nameCompare;
    }


}

public class ComparatorImpl {
    public static void main(String[] args) {
        List<student> list= new ArrayList<>();
        list.add(new student(1,"aaa",10));
        list.add(new student(2,"bbb",50));
        list.add(new student(3,"ccc",450));
        list.add(new student(4,"ccc",30));
        list.add(new student(5,"ccc",40));

        Collections.sort(list,new StudentComparator());

        for(student s:list){
            System.out.println(s.rno+" "+s.name+" "+s.marks);
        }

    }
}
