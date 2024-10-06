package Arrays;

public class FindNumberWithEvenNumberOfDigit {
    public static void main(String[] args) {
        int []nums = {12,345,2,6,7896};

        System.out.println(findNumbers(nums));
    }


    public static int findNumbers(int[] nums) {

        int number_of_even = 0;

        for (int i = 0 ; i < nums.length ; i++){
            if (findEven(nums[i])){
                number_of_even++;
            }
        }

        return number_of_even;
    }
    public static boolean findEven(int num){
        String str = String.valueOf(num);
        if (str.length() % 2 == 0){
            return true;
        }

        return false;
    }


}
