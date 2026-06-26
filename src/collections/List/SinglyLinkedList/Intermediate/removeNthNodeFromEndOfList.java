package collections.List.SinglyLinkedList.Intermediate;

import org.w3c.dom.Node;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
    }
}

public class removeNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode ll= new ListNode(1);
        ll.next= new ListNode(2);
        ll.next.next = new ListNode(3);
        ll.next.next.next = new ListNode(4);
        ll.next.next.next.next=new ListNode(5);

        ListNode temp = ll;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
            remove(ll,4);
        temp= ll;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void remove(ListNode ll,int n){
        ListNode fast= ll;
        ListNode slow = ll;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

    }

}
