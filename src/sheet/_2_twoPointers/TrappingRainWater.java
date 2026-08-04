package sheet._2_twoPointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] heights) {

            int n = heights.length;

            // find tallest bar index
            int maxIndex = 0;

            for (int i = 1; i < n; i++) {
                if (heights[i] > heights[maxIndex]) {
                    maxIndex = i;
                }
            }

            int water = 0;

            // left side
            int leftMax = 0;

            for (int i = 0; i < maxIndex; i++) {

                leftMax = Math.max(leftMax, heights[i]);

                water += leftMax - heights[i];
            }

            // right side
            int rightMax = 0;

            for (int i = n - 1; i > maxIndex; i--) {

                rightMax = Math.max(rightMax, heights[i]);

                water += rightMax - heights[i];
            }

            return water;
    }
}
