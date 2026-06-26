package collections.Map.LinkedHashMap;

import java.util.LinkedHashMap;

public class impl {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
        map.put(1,null);
        map.put(2,null);
        map.put(3,null);
        map.put(null,"2");

        System.out.println(map.toString());

    }
}
