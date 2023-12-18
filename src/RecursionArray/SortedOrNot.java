package RecursionArray;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] nums = {1 , 90 , 5};
        System.out.println(check(nums , 0));
    }

    public static boolean check(int[] nums , int index ){
       if (index == nums.length-1){
           return true;
       }
       return nums[index]<nums[index+1] && check(nums , index + 1);
    }
}
