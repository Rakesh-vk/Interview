import java.sql.SQLOutput;
import java.util.Stack;

public class valid {
    public static void main(String[] args) {
        String[] tokens={"2","1","+","3","*"};
        int len= tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<len;i++){
            String c = tokens[i];
            switch(c){
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    st.push(st.pop() - st.pop());
                    break;
                case "/":
                    st.push(st.pop() / st.pop());
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                default: st.push(Integer.parseInt(c));
            }
        }

        System.out.println(" sum : "+st.peek());

    }
}
