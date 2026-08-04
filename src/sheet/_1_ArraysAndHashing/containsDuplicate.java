package sheet._1_ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (set.contains(n)){
                System.out.println(n);
                return ;
            }
            set.add(n);
        }
    }
}
