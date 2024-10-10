package Arrays;
public class RotateTheArray {
    public static void main(String[] args) {

    }

    public static void rotate_without_using_extra_space(int[] nums, int k) {
        int n = nums.length;
        reverse(nums , 0 , n-1);
        reverse(nums , 0 , k-1 );
        reverse(nums , k , n-1);
    }


    public static void  reverse(int []nums , int start  , int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

        public static void rotate(int[] nums, int k) {
        int temp[] = new int[nums.length];
        int n = nums.length;

        // this modulus makes sure that of k > n , it wraps around
        // like if n = 7 and k = 10 , that means we have to do 10 rotation
        // then we will achieve same thingh on doing the 7 rotation

        k = k % n;
        for(int i = n-k ; i < nums.length ; i++){
            // start filling from start in the temp
            temp[i - (n-k)] = nums[i];
        }
        for(int i = k ; i < n ; i++){
            temp[i] = nums[i - k];
        }
        for(int i = 0 ; i < n ;i++){
            nums[i] = temp[i];
        }


    }
}
