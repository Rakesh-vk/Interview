package practice.basics;

public class feedbackValidator {
    public static boolean isValidFeedback(String feedback){
        return feedback !=null && !feedback.trim().isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValidFeedback("hello"));
        System.out.println(isValidFeedback(""));
        System.out.println(isValidFeedback(null));
    }
}
