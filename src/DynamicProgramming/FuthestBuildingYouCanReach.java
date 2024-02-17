package DynamicProgramming;

import java.util.Arrays;

public class FuthestBuildingYouCanReach {
    public static void main(String[] args) {

        int[]heights = {4,2,7,6,9,14,12};
        int bricks = 5 ;
        int ladders = 1;


        System.out.println(furthestBuilding(heights , bricks , ladders));
    }




    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int [][]memo = new int[bricks+1][ladders + 1];
        for (int num[] : memo){
            Arrays.fill(num , -1);
        }
        int n = heights.length;
        return solve( 0 , heights , bricks , ladders , memo);
    }

    public static int solve(int idx , int[] height , int bricks , int ladder , int [][]memo){
        if (idx == height.length -1){
            return 0;
        }

        if (memo[bricks][ladder] != -1){
            return memo[bricks][ladder];
        }

        if (height[idx + 1] <= height[idx]){
             memo[bricks][ladder] =  1 + solve(idx + 1 , height , bricks , ladder , memo);
        }else {

            // now we need either brick or either by ladder
            int byBrick = 0;
            int byLadder = 0;

            // check the no of brick require for jumping to next building // if available then jump
            int diff = height[idx + 1] - height[idx];
            if (bricks >= diff){
                byBrick = 1 + solve(idx + 1 , height , bricks - diff , ladder , memo);
            }
            if (ladder > 0){
                byLadder = 1 + solve(idx + 1 , height , bricks , ladder -1  , memo);
            }

             memo[bricks][ladder] =  Math.max(byLadder , byBrick);
        }
        return memo[bricks][ladder];

    }











//    public static int furthestBuilding1(int[] heights, int bricks, int ladders) {
//        return solve1(0 , heights , bricks , ladders);
//    }
//
//    public static int solve1(int index , int[] heights , int bricks , int ladder){
//        if (index == heights.length-1){
//            return 0;
//        }
//        int byBricks  = 0;
//        int byLadder = 0;
//        if (heights[index + 1] < heights[index]){
//            return 1 + solve(index + 1 , heights , bricks , ladder);
//        }else {
//            if (heights[index+1] - heights[index] <= bricks){
//                byBricks = 1 + solve(index+1 , heights , bricks- heights[index+1] - heights[index], ladder);
//            }else {
//                byLadder = 1 + solve(index + 1 , heights , bricks , ladder-1);
//            }
//        }
//
//        return Math.max(byLadder , byBricks);
//
//    }
}
