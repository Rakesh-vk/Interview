package collections.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinStack {
    List<Integer> stack;
    List<Integer> minStack;
    public MinStack(){
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    public void push(int val){
        stack.add(val);
        int min=val;
        if(!minStack.isEmpty()){
            min = Math.min(minStack.get(minStack.size()-1),min);
        }
        minStack.add(min);
    }
    public void pop(){
        if(!stack.isEmpty()){
            stack.remove(stack.size()-1);
            minStack.remove(minStack.size()-1);
        }
    }
    public int top(){
        if(!stack.isEmpty())
            return stack.get(stack.size()-1);
        return 0;
    }
    public int getMin(){
        if(!minStack.isEmpty()){
            return minStack.get(minStack.size()-1);
        }
        return 0;
    }
    public void print(){
        System.out.println(stack);
        System.out.println(minStack);
    }

    public static void main(String[] args) {
        MinStack st= new MinStack();
        st.push(10);
        st.push(2);
        st.push(5);
        st.push(2);
        st.push(8);
        st.push(1);
        st.print();
        System.out.println(st.top()+" "+st.getMin());
    }
}
