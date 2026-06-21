package collections.List.SinglyLinkedList.basic;

public class basicImpl {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(10);

        list.head.next = list.head;

        System.out.println(list.detectCycle());


    }
}
