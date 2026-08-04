package BitManipulation.basics;

public class toggleIthBit {
    public static void main(String[] args) {
        int n=9,i=2;
        System.out.println(toggle(n,i));
    }
    public static int toggle(int n,int i){
        return n ^ (i<<1);
    }
}
