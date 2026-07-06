package collections.Heap;

public class MinHeapTest {
    public static void main(String[] args) throws Exception {
        MinHeap heap = new MinHeap(10);
        heap.insert(10);
        heap.insert(30);
        heap.insert(60);
        heap.insert(20);
        heap.printHeap();

        heap.deleteMax();

        heap.printHeap();

        int[] arr={1,4,2,6,4,7,3};
        heap.heapify(arr);
        heap.printHeap();

    }
}
