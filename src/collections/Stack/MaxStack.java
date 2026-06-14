package collections.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        // If maxStack is empty, the current value is the maximum.
        // Otherwise, compare with the current top of maxStack.
        if (maxStack.isEmpty()) {
            maxStack.push(val);
        } else {
            maxStack.push(Math.max(val, maxStack.peek()));
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        maxStack.pop();
        return mainStack.pop();
    }

    public int top() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mainStack.peek();
    }

    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.peek(); // Top of maxStack always holds the global max
    }
    public void print(){
        System.out.println(mainStack);
        System.out.println(maxStack);
    }

    public static void main(String[] args) {
        MaxStack st= new MaxStack();
        st.push(10);
        st.push(2);
        st.push(5);
        st.push(2);
        st.push(8);
        st.push(1);
        st.print();
        System.out.println(st.top()+" "+st.getMax());
    }
}
