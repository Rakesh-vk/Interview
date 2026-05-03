package practice.OOPS;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class staff{
    private String name;
    private String code;
    private String team;
    staff(String name,String code,String team){
        this.name=name;
        this.code=code;
        this.team=team;
    }
    public String getName(){return name;}
    public String getCode(){return code;}
    public String getTeame(){return team;}

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(this instanceof staff)) return false;
        return code.equals(((staff)obj).code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "%s(%s) Team %s".formatted(name,code,team);
    }
}
public class staffRecordCreation {
    public static void main(String[] args) {
        Set<staff> records= new HashSet<>();
        records.add(new staff("Rakesh","1211","all"));
        records.add(new staff("Raakesh","12a11","al1l"));
        records.add(new staff("Raskesh","121z1","all2"));
        records.forEach(System.out::println);

    }
}
