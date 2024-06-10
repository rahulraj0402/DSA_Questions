package Arrays;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {

    }
    public int heightChecker(int[] heights) {
        int count = 0 ;
        int n = heights.length;

        // store the heights to expected
        int []expected = new int[n];

        for (int i = 0 ; i < n ; i++){
            expected[i] = heights[i];
        }

        // sort the expected
        Arrays.sort(expected);

        for (int i = 0 ; i < n ; i++){
            if (expected[i] != heights[i]){
                count++;
            }
        }
        return count;
    }
}
