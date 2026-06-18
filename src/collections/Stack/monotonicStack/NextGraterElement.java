package collections.Stack.monotonicStack;

import java.util.Stack;

public class NextGraterElement {
    public static void main(String[] args) {
        int[] input= {1,0,2,3,1};
        int n= input.length;
        int[] result = new int[n];
        Stack<Integer> stack= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<input[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=-1;
            }
            else {
                result[i]=stack.peek();
            }
            stack.push(input[i]);
        }
        for (int j:result){
            System.out.print(j+" ");
        }
    }

}
