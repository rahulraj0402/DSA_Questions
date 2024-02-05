package CSES;
// https://cses.fi/problemset/task/1083/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {2 , 3 , 1 , 5};
        System.out.println(arr.length);
    }

    public  static  int  missing(int[] arr){

        int n  = arr.length + 1;

        // expected sum
        int expectedSum = n * (n + 1) / 2;

        // actual sum
        int actualSum = Arrays.stream(arr).sum();

        return expectedSum - actualSum;


    }
}
