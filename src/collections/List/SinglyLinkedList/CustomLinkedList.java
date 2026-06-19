package collections.List.SinglyLinkedList;

public class CustomLinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node tail;
    int len=0;
    //basic operation
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head= newNode;
        }
        else {
            newNode.next=head;
            head=newNode;
        }
        len++;
    }
    public void addLast(int data){
        Node newNode= new Node(data);
        if(head==null){
            head=newNode;
        }
        Node temp= head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        len++;
    }
    public void removeFirst(){
        len--;
        if(head.next!=null){
            head=head.next;
        }
        else
         head=null;
    }
    public void removeLast() {
        len--;
        // Empty list or single node list
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        // Move to the second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Remove the last node
        temp.next = null;
    }
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public int size(){
        return len;
    }
    public boolean isEmpty(){
        return head==null;
    }

    // access operations
    public int getFirst(){
        if(head!=null){return head.data;}
        return -1;
    }
    public int getLast(){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp.data;
    }
    public int get(int idx){
        Node temp=head;
        int count=0;
        while(temp!=null)
        { if (count==idx-1){
            return temp.data;

        }
        count++;
        temp=temp.next;}
        return -1;
    }

    // Insert/Delete operation
    public void add(int index, int value) {

        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node newNode = new Node(value);

        // Insert at head
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        // Move to node at index - 1
        for (int i = 0; i < index - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Invalid index
        if (temp == null) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }


    public static void main(String[] args){
        CustomLinkedList list= new CustomLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.print();
       list.add(2,20);
        list.print();


    }
}
