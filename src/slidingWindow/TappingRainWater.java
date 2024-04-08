package slidingWindow;

import java.io.FileOutputStream;

public class TappingRainWater {
    public static void main(String[] args) {
        int []height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        int unitsOfWater = 0 ;
        // lets find the prefix max

        int []preMax = new int[height.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < preMax.length ; i++){
            max = Math.max(max , height[i]);
            preMax[i] = max;
        }



        int []suffMax = new int[height.length];
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1 ; i >= 0 ; i--){
            max = Math.max(max , height[i]);
            suffMax[i] = max;
        }


        // now lets compute the units of water

        for (int i = 0 ; i < height.length ; i++){
            unitsOfWater += Math.min(preMax[i] , suffMax[i]) - height[i];
        }

        return unitsOfWater;

    }






}
