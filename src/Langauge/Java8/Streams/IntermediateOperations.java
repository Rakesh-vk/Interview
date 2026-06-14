package Langauge.Java8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class IntermediateOperations {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        List<List<String>> list=Arrays.asList(
                Arrays.asList("Geeks", "For"),
                Arrays.asList("GeeksForGeeks", "A computer portal"),
                Arrays.asList("Java", "Programming")
        );
        // filter is used to filter out data
//        int[] array = Arrays.stream(arr).filter(i -> i > 2).toArray();

        // flatmap is used to reduce the list of list into list
        List<String> list2 = list.stream()
                .flatMap(list1 -> list1.stream())
                .toList();
        System.out.println(list2);

        // map
        Arrays.stream(arr).map(x->x+2).forEach(x->System.out.print(x+" "));
        System.out.println();
        // reduce
        OptionalInt reduce = Arrays.stream(arr).reduce(Integer::sum);
        System.out.println(reduce.getAsInt());

    }
    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.println(i);
        }
    }
}
