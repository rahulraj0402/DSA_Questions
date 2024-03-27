package Arrays;

public class SubArrayLessThenK {

    public static void main(String[] args) {
        int []arr = {10 , 5 , 2 , 6};
        System.out.println(numSubarrayProductLessThanK(arr , 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
       if( k <= 1) return 0;
       int left =0 ;
       int  right = 0 ;
       int product = 1;
       int n = nums.length;
       int count = 0 ;

       while (right < n){
           product*=nums[right];
           while (product >= k){
              product = product / nums[left++];
           }
           count += 1 + ( right - left);
           right++;

       }

       return count;

    }
}
