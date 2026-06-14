package collections.List;

import java.util.Stack;

class MyLinkedList<T> {
    Node<T> head;
    static class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }
    public static MyLinkedList insert(MyLinkedList list, int data){
        // create a new node with data
        Node newNode= new Node(data);
        // to insert we must first check if the list is empty
        if(list.head==null){
            list.head=newNode;
        }
        // if list contains nodes travers to end of the list, make next pointer point to new node
        else{
            Node last= list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newNode;
        }
        return list;
    }
    public static void printList(MyLinkedList list){
        Node itr=list.head;
        while(itr!=null) {
            System.out.print(itr.data+" -> ");
            itr = itr.next;
        }
        System.out.print("null \n");
    }
    public void deleteByKey(MyLinkedList list, T key){

        Node next = list.head;
        Node prev = null;
        if(next!=null && next.data==key){
            list.head=next.next;
            return ;
        }
        while(next!=null && next.data!=key){
            prev = next;
            next= next.next;
        }
        if(next!=null){
            prev.next=next.next;
        }
    }
    public static void deleteFirstNode(MyLinkedList list){
        list.head=list.head.next;
    }
    public static void deleteLastNode(MyLinkedList list){
        Node curNode=list.head,prev=null;
        // traverse to end
        while(curNode.next!=null){
            prev=curNode;
            curNode=curNode.next;
        }
        prev.next=null;


    }
    public void insertAfterKey(MyLinkedList list, T key, T data){
        // case 1 element/key is present
        // element/ key is present at start
        Node curNode= list.head;
        Node newNode= new Node(data);
        if(curNode != null && curNode.data==key){
            newNode.next=curNode.next;
            curNode.next=newNode;
            return ;
        }
        // element/key is present at middle
        // traverse to node
        while(curNode!=null && curNode.data!=key){
            curNode=curNode.next;
        }
        if(curNode!=null){
            newNode.next=curNode.next;
            curNode.next=newNode;
        }
        else{
            curNode.next=newNode;
        }
        // element/ key is present at end
        // case 2 element/key is not present
    }
    public void reverseLinkedListUsingStack(MyLinkedList list){
        // here I am using stack to store the data in stack as stack works on LIFO
        // first iteration will add the elements to stack
        // second iteration will add the element to linkedlist in reverse order
        // time complexity O(n) = O(n) first iteration + O(n) second iteration.
        // space complexity O(n) as we are adding n elements to stack.
        // not efficient way as the stack will take n memory
        Stack<T> st= new Stack<>();
        Node temp = list.head;
        while(temp!=null){
            st.add((T) temp.data);
            temp=temp.next;
        }
        temp = list.head;
        while(temp!=null){
            temp.data=st.pop();
            temp=temp.next;
        }
        printList(list);
    }
    public static void reverseLinkedListUsingTwoPointers(MyLinkedList list) {
        // using the two pointers one is curNode another is prevNode
        // loop till temp reaches null i.e while(temp!=null)
        // save curNode.next in a variable i.e Node nextNode = curNode.next
        // point curNode.next = prev
        // prev = curNode
        // curNode = next
        // time complexity O(n) as we need to iterate through the linked list with n elements
        // space complexity O(1) as we are not using any extra space
        Node prev = list.head;
        Node curr = list.head;
        if(curr.next == null) return;
        curr=curr.next;
        while(curr!= null){
            Node temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        list.head.next=null;
        list.head=prev;
        printList(list);
     }
     public static void reverseLinkedListUsingRecursion(MyLinkedList list){
        //recursion is checking what we are doing repeatedly and finding the base case
         // and working in backword order
         // time complexity O(n)
         // space complexity O(n)
        Node head= list.head;
        list.head=reverse(head);
        printList(list);

     }
     public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead = reverse(head.next);
        Node front =head.next;
        front.next= head;
        head.next=null;
        return newHead;
     }

}
public class LinkedLists {
    public static void main(String[] args) {
        MyLinkedList list= new MyLinkedList();
        list = MyLinkedList.insert(list,10);
        list = MyLinkedList.insert(list,20);
        list = MyLinkedList.insert(list,30);
        list = MyLinkedList.insert(list,40);
        list = MyLinkedList.insert(list,50);
        MyLinkedList.printList(list);
        MyLinkedList.reverseLinkedListUsingRecursion(list);

//        LinkedList.reverseLinkedListUsingTwoPointers(list);
//        LinkedList.printList(list);
//        LinkedList.reverseLinkedListUsingStack(list);
//        LinkedList.printList(list);
////        LinkedList.deleteByKey(list,10);
////        LinkedList.printList(list);
//        LinkedList.insertAfterKey(list,50,12);
//        LinkedList.printList(list);
////        LinkedList.deleteFirstNode(list);
//        LinkedList.deleteLastNode(list);
//        LinkedList.printList(list);
        String st="abc";


    }
}
