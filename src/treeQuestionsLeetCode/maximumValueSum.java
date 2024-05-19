package treeQuestionsLeetCode;

public class maximumValueSum {
    public static void main(String[] args) {
        int []nums = {1,2,1 } ;
        int k = 3 ;
        int [][]edges = {{0,1,} , {0,2}};
        System.out.println(maximumValueSum1(nums , k , edges));
    }
    public static long maximumValueSum1(int[] nums, int k, int[][] edges) {

        int sum = 0;
        int count = 0;
        int minLoss = Integer.MAX_VALUE;

        for (int num : nums){
            if ((num ^ k) > num) {
                count++;
                sum += (num^k);
            }else {
               sum += num;
            }
            minLoss = Math.min(minLoss , Math.abs(num - (num^k)));
        }

        if (count % 2 == 0) return sum;
        return sum - minLoss;
    }
}
