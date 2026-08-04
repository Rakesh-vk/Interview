package collections.List.SinglyLinkedList.basic;

public class MyLinkedList {

     ListNode head;
     ListNode tail;
    private int size;

    // ================= ADD =================
    public void addFirst(int data) {
        ListNode newListNode = new ListNode(data);
        if (head == null) {
            head = tail = newListNode;
        } else {
            newListNode.next = head;
            head = newListNode;
        }
        size++;
    }

    public void addLast(int data) {
        ListNode newListNode = new ListNode(data);
        if (head == null) {
            head = tail = newListNode;
        } else {
            tail.next = newListNode;
            tail = newListNode;
        }
        size++;
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        ListNode prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        ListNode newListNode = new ListNode(data);
        newListNode.next = prev.next;
        prev.next = newListNode;
        size++;
    }

    public int removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int removed = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return removed;
    }

    public int removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head == tail) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }
        ListNode temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int value = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return value;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        ListNode prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        int value = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return value;
    }

    public int getFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    // ================= GET =================

    public int getLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean contains(int value) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // ================= SEARCH =================

    public int indexOf(int value) {
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == value) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    // ================= UTIL =================

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ================= REVERSE =================
    public void reverse() {
        ListNode prev = null;
        ListNode curr = head;
        tail = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // ================= MIDDLE =================
    public int getMiddle() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    // ========= FIND NTH NODE FROM END ==========
    public int findNthNodeFromEnd(int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }


    // ========= REMOVE NTH NODE FROM END ========
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }

    // ========= MERGE TWO SORTED LIST ===========
    public MyLinkedList mergeTwoSortedList(MyLinkedList list1, MyLinkedList list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        ListNode p1 = list1.head;
        ListNode p2 = list2.head;

        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }

        if (p1 != null)
            temp.next = p1;

        if (p2 != null)
            temp.next = p2;

        MyLinkedList merged = new MyLinkedList();
        merged.head = dummy.next;

        return merged;
    }

    // ======== REVERSE LINKED LIST ==============
    public void reverseLinkedlist(){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        print();
    }

    // ============= PALINDROME ===================
    public boolean isPalindrome() {
        // find the middle
        // reverse 2nd half
        // compare first part with

        // if list is empty or only have one element
        if (head == null || head.next == null) {
            return true;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Odd length -> skip middle node
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare both halves
        ListNode p1 = head;
        ListNode p2 = prev;

        while (p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // ============ DETECT CYCLE ==================
    public boolean detectCycle(){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null  ){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    // =========== FIRST NODE IN CYCLE ===========
    public ListNode findCycleStart() {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Find start of cycle
        fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode getHead() {
        return head;
    }

    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }
}