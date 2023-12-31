package slidingWindow;

public class LongestMountainArray {
    public static void main(String[] args) {

    }

    public int longestMountain(int[] arr) {

        int res = 0 ;
        int n = arr.length;

        for (int i = 0 ; i < n ; i++){
            int count = 1;

            // find the inc sequence
            int j = i ;
            while (j<n && arr[j] > arr[j-1]){
                j++;
                count++;
            }
            // find the dec sequence
            while ( i != j && j<n && arr[j] < arr[j-1]){
                j++;
                count++;
            }
            // max of length
            if (i != j && count > 2){
                res = Math.max(res , count);
                j--;
            }



        }


        return res;
    }
}
