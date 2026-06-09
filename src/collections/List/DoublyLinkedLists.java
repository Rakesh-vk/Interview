package collections.List;



class DoublyLinkedList{
    Node head;
    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            prev=null;
            next=null;
        }
    }
    public static void insert(DoublyLinkedList list,int data){
        // list is empty
        Node newNode = new Node(data);
        if(list.head==null){
            list.head=newNode;
            return;
        }
        // insert at end
        //traverse to end and add
        Node curNode= list.head;
        while(curNode.next!=null){
            curNode=curNode.next;
        }
        curNode.next=newNode;
        newNode.prev=curNode;
    }
    public static void printList(DoublyLinkedList list){
        Node curNode=list.head;
        System.out.print("null <-> ");
        while(curNode!=null){
            System.out.print(curNode.data+" <-> ");
            curNode=curNode.next;
        }
        System.out.println("null");
    }
    public static void insertAtBeginning(DoublyLinkedList list,int data){
        Node newNode = new Node(data);
        Node curNode =  list.head;
        newNode.next=curNode;
        curNode.prev=newNode;
        list.head=newNode;

    }
    public static void DeleteAtEnd(DoublyLinkedList list){
        Node curNode= list.head;
        while(curNode.next!=null){
            curNode=curNode.next;
        }
        curNode.prev.next=null;
        curNode.prev=null;
        DoublyLinkedList.printList(list);
    }
    public static void DeleteAtBeginning(DoublyLinkedList list){
        Node curNode = list.head;
        list.head=curNode.next;
        list.head.prev=null;
        curNode.next=null;

        DoublyLinkedList.printList(list);
    }
    public static void DeleteIntermediate(DoublyLinkedList list){

    }
}


public class DoublyLinkedLists {
    public static void main(String[] args) {
        DoublyLinkedList list= new DoublyLinkedList();
        DoublyLinkedList.insert(list,10);
        DoublyLinkedList.insert(list,20);
        DoublyLinkedList.insert(list,30);
        DoublyLinkedList.insert(list,40);
        DoublyLinkedList.insert(list,50);
        DoublyLinkedList.printList(list);
        DoublyLinkedList.insertAtBeginning(list,22);
        DoublyLinkedList.printList(list);
        DoublyLinkedList.DeleteAtEnd(list);
        DoublyLinkedList.DeleteAtBeginning(list);


    }
}
