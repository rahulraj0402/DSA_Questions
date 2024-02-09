package RecursionArray;

public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        if (n < 0){
            return Integer.MAX_VALUE;
        }
        if (n == 0){
            return 0;
        }

        int min  = n;

        for (int i = 1 ; i*i <= n ; i++){
            min = Math.min(min  , numSquares(n-i*i));
        }

        return min+1;
    }
}
