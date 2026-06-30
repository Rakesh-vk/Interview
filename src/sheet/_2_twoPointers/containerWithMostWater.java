package sheet._2_twoPointers;

public class containerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int result=0;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int w=j-i;
            int area=h*w;
            result=Math.max(result,area);
            if(height[i] < height[j]){
                i++;
            }
            else j--;
        }
        return result;
    }
}
