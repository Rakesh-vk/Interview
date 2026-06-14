package Langauge.Java8.Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double salary;

    // Constructor
    public Employee(int id, String name, int age, String gender, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    // Getters
    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Langauge.Employee{id=%d, name='%s', age=%d, gender='%s', salary=%.2f}", id, name, age, gender, salary);
    }
}
public class impl {
    public static void main(String[] args) {
//        isPalindrome();
//        genderCount();
//        sumOfEvenAndOdd();
//        duplicatesInArray();
//        removeAllOccurancesOfAChar();
//        findSpecialCharacters();
//        numbersStartingWith1();
//        findEmployeesWithHighestSalary();
//        concatinateStirngsInAnArray();
//        GroupStringsByLength();
//        filterNumbersGreaterThan10AndFindAvg();
//        convertStringtoMapwithItsLength();


    }
    public static void convertStringtoMapwithItsLength(){
        List<String> list= Arrays.asList("Hello","Hi","How","are");
        Map<String, Integer> collect = list.stream()
                .collect(Collectors.toMap(str -> str, String::length));
        System.out.println(collect);
    }
    public static void filterNumbersGreaterThan10AndFindAvg(){
        List<Integer> list = Arrays.asList(1,2,1,21,4,23,54);
        OptionalDouble average = list.stream()
                .filter(n -> n > 10)
                .mapToInt(n -> n)
                .average();
        System.out.println(average.getAsDouble());
    }
    public static void GroupStringsByLength(){
        List<String> list= Arrays.asList("Hello","hi","how","are","you");
        Map<Integer, List<String>> collect = list.stream().
                collect(Collectors.groupingBy(String::length));

        System.out.println(collect);
    }
    public static void concatinateStirngsInAnArray(){
        List<String> list= Arrays.asList("Apple","Banana","watermelon");
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
    public static void findEmployeesWithHighestSalary(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, "Male", 50000),
                new Employee(2, "Jane Smith", 25, "Female", 20000),
                new Employee(3, "Mike Johnson", 40, "Male", 70000),
                new Employee(4, "Emily Davis", 35, "Female", 30000),
                new Employee(5, "Robert Brown", 50, "Male", 90000)
        );
        Optional<Employee> highestSalary =employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(highestSalary);
    }
    public static void numbersStartingWith1(){
        List<Integer> arr=Arrays.asList(12,3,65,7,19,33,17);
        List<Integer> collect = arr.stream().
                filter(c -> String.valueOf(c).startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
    public static void findSpecialCharacters(){
        String str="Hello W)rld !..#@%";
        String st= str.chars().filter(c -> !Character.isLetterOrDigit(c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(st);


    }
    public static void removeAllOccurancesOfAChar(){
        String str="java programing";
        char ch='a';
        String collect = str.chars().filter(a -> a != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(collect);
    }
    public static void duplicatesInArray(){
        List<Integer> nums= Arrays.asList(1,2,3,4,2,3,5,5,1,6);
        List<Integer> collect = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect);
    }
    public static void sumOfEvenAndOdd(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, Integer> collect = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0, Collectors.summingInt(Integer::intValue)));
        System.out.println(collect);
    }
    public static void genderCount(){
        System.out.println("Gender count");
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, "Male", 50000),
                new Employee(2, "Jane Smith", 25, "Female", 20000),
                new Employee(3, "Mike Johnson", 40, "Male", 70000),
                new Employee(4, "Emily Davis", 35, "Female", 30000),
                new Employee(5, "Robert Brown", 50, "Male", 90000)
        );
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect);
        Map<String, Double> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect1);
    }
    public static void isPalindrome(){
        String name="hello";
        boolean b = IntStream.range(0, name.length() / 2)
                .allMatch(i -> name.charAt(i) == name.charAt(name.length() - i - 1));
        System.out.println(b);
    }

}
