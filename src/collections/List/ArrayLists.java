package collections.List;

import java.util.ArrayList;
import java.util.List;

// Elements can be accessed Randomly using index
// Duplicates allowed
// Elements are stored in the order they are inserted
// ArrayList is not thread safe
public class ArrayLists {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        // adding elements
        list.add("Hello"); // adding element at the end of the Arraylist
        list.add(0,"hi");    // adding elements at a index

    }
}
