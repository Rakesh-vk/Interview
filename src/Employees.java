public class Employees {
    private int eno;
    private String name;
    private int salary;

    public Employees(int eno, String name, int salary) {
        this.eno = eno;
        this.name = name;
        this.salary = salary;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
