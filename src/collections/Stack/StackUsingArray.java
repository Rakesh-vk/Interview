package collections.Stack;

public class StackUsingArray {
    int[] stack;
    int top=-1;
    int maxsize=0;
    public StackUsingArray(int maxsize){
        stack = new int[maxsize];
        this.maxsize=maxsize;
    }
    public void push(int data){
        if(top<=maxsize-1){
            stack[++top]=data;
        }
        else {
            System.out.println("Stack is full");
        }
    }
    public int pop(){
        if(top<0)
             System.out.println("Stack is empty");
        top--;
        return stack[top+1];
    }
    public int peek(){
        if(top >maxsize-1){
            System.out.println("stack is empty");
        }
        return stack[top];
    }
    public int size(){
        return top+1;
    }

    public static void main(String[] args) {
        StackUsingArray st=new StackUsingArray(5);
        st.push(10);
        st.push(20);
        st.push(30);
    }
}
