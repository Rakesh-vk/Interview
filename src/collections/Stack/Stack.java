package collections.Stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
      queue.add(x);

      for(int i=0;i< queue.size()-1;i++)
      {
         int ele= queue.remove();
         queue.add(ele);
      }
    }

    public int pop() {
       int ele= queue.remove();
       return ele;
    }

    public int top() {
     return  queue.peek();
    }

    public boolean empty() {
      return  queue.isEmpty();
    }
}

