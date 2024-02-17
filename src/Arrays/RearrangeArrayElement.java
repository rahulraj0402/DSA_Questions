package Arrays;

import java.util.ArrayList;

public class RearrangeArrayElement {
    public static void main(String[] args) {

    }

    public int[] rearrangeArray(int[] nums) {

        ArrayList<Integer> positive  = new ArrayList<>();
        ArrayList<Integer>  negative = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();


        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] < 0){
                negative.add(nums[i]);
            }
            else {
                positive.add(nums[i]);
            }
        }

        int positiveIndex = 0 ;
        int negativeIndex = 0;

        boolean flag = true;

        for (int i =  0 ; i < nums.length ; i++){

            if (flag && positiveIndex < positive.size() ){
                ans.add(positive.get(positiveIndex++));
                flag = false;
            }
            if (!flag && negativeIndex < negative.size()){
                ans.add(negative.get(negativeIndex++));
                flag = true;
            }
        }


        int [] res = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            res[i] = ans.get(i);
        }

        return res;

    }
}
