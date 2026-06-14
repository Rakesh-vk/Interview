package collections.List;

public class CustomLinkedList{
    Node head;
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void insert(int data){
        Node newNode= new Node(data);
        if(head==null){
            head= newNode;
            return;
        }
        Node temp=head;
        while(temp.next!= null){
            temp=temp.next;
        }
        temp.next=newNode;

    }
    public int findMiddle(){
        Node slow=head,fast=head;
        while (fast!= null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        assert slow != null;
        return slow.data;
    }

    public static void main(String[] args) {
        CustomLinkedList list= new CustomLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);

        Node temp = list.head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("\nmiddle element is : "+list.findMiddle());
    }

}


