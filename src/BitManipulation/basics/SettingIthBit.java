package BitManipulation.basics;

public class SettingIthBit {
    public static void main(String[] args) {
        int n=9,i=2;
        System.out.println(set(n,i));
    }
    public static int set(int n, int i){
        return n | (1 << i);
    }
}
