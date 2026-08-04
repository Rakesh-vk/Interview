package collections.Heap;

public class MaxHeapTest {
    public static void main(String[] args) throws Exception{
        MaxHeap heap= new MaxHeap(10);
        heap.insert(20);
        heap.insert(10);
        heap.insert(40);
        heap.insert(24);

        heap.printHeap();

        heap.deleteMax();

        heap.printHeap();
        int[] arr= {1,5,2,7,4,8,5};
        heap.heapify(arr);
        heap.printHeap();


    }
}
