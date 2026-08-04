package BitManipulation.basics;

public class clearingIthBit {
    public static void main(String[] args) {
        int n=9,i=2;

        System.out.println(clear(n,i));

    }
    public static int clear(int n,int i){
        return n | ~(i<<1);
    }
}
