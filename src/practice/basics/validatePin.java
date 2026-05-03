package practice.basics;

public class validatePin {
    public static boolean isValidPin(String s){
        if(s==null) return false;
        int len=s.length();
        if(len!=4 && len!=6) return false;
        for(int i=0;i<len;i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidPin("1234"));
        System.out.println(isValidPin("12134"));
        System.out.println(isValidPin("1234s"));
        String s="12512";
        boolean ok= s!=null && s.matches("^\\d{4}$|^\\d{6}");
        System.out.println(ok);
    }
}
