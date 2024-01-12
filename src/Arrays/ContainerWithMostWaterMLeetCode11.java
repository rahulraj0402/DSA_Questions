package Arrays;

public class ContainerWithMostWaterMLeetCode11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        int left = 0 ;
        int right = height.length-1;
        int max = 0 ;

        while (left < right){
            int leftHeight = height[left];
            int rightHeight = height[right];

            int base = right - left;
            int minBar = Math.min(leftHeight , rightHeight);
            int currentArea = minBar * base;

            max = Math.max(currentArea , max);
            if (height[left] < height[rightHeight]){
                left++;
            }else {
                right--;
            }


        }

        return max;
    }
}
