package RecursionArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LargestDivisibleSubset {


    public static void main(String[] args) {
        int arr[] = {1,4,2,8};
        System.out.println(largestDivisibleSubset(arr));
    }


    public  static List<Integer> largestDivisibleSubset(int[] nums) {
        // first sort the aray
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        generate( 0 , nums , result , temp , -1);

        return result;
    }

    private static void generate(int index, int[] nums, List<Integer> result, List<Integer> temp, int prevNumber) {

        if (index >= nums.length){
            if (temp.size() > result.size()){
                result.clear();
                result.addAll(temp);
            }
            return;
        }


        if (prevNumber == -1 || nums[index] % prevNumber == 0){
            temp.add(nums[index]);   // take the element
            generate(index + 1 , nums , result , temp , nums[index]);   // here we are taking it so we have putted nums[index]
            temp.remove(temp.size()-1);  // dont take the element
        }

        // for not taking the element we have to call the recursion again
        generate(index + 1, nums , result , temp , prevNumber);
    }


}
