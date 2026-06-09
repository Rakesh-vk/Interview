import org.junit.runner.Runner;

import java.util.Objects;

public class sample {
    public static void main(String[] args) {
       char ch='e';
        int hash=0;
       hash= 31*hash+ch;
       int hashcode= hash&(16-1);
        System.out.println(hashcode);
    }
}
