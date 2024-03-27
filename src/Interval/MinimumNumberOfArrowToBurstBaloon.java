package Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowToBurstBaloon {
    public static void main(String[] args) {

        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
        int []prev = points[0];

        int arrow = 1;

        for (int i = 1 ; i < n ; i++){

            int currentSP = points[i][0];
            int currentEP = points[i][1];

            int prevSP = prev[0];
            int prevEP = prev[1];

            if (currentSP > prevEP){
                // no overlapping
                // assign prev = current and search for further possiblities
                arrow++;
                prev = points[i];
            }else {
                // overlapping
                // fid the overlapping part
                prev[0] = Math.max(currentSP , prevSP);
                prev[1] = Math.min(currentEP , prevEP);

            }
        }

        return arrow;
    }
}
