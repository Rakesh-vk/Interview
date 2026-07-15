package BitManipulation;

public class BinaryToDecimal {
    public static void main(String[] args) {
        String binary = "0101";
        int j=0,num=0;
        for(int i=binary.length()-1;i>=0;i--){
            char ch = binary.charAt(i);
            if(ch=='1'){
                num += (int) Math.pow(2,j);
            }
            j++;
        }
        System.out.println(num);
    }
}
