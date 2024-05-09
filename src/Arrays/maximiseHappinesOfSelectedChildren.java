package Arrays;

import java.io.FileOutputStream;
import java.util.Arrays;

public class maximiseHappinesOfSelectedChildren {
    public static void main(String[] args) {
       int[] happiness = {1,2,3};
       int k = 2;

    }

    public static long maximumHappinessSum(int[] happiness, int k) {

        // [ since we want the max happiness so we will sort the array in decending order | now reverse
        Arrays.sort(happiness);
        reverse(happiness);

        int count = 0 ;
        long result = 0L ;

        for (int i = 0 ; i < k ; i++){
            result += Math.max(happiness[i] - count , 0);
            count++;
        }
        return result;
    }

    public static void reverse(int arr[]){
        int i = 0 ;
        int j = arr.length-1;

        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
