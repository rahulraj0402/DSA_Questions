package DynamicProgramming;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(12));
        System.out.println(fibo(12));
    }

    // memoisation

    public static int fibo(int n){
        if (n <= 1){
            return n;
        }

        int []dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];


    }





    public static int fib(int n) {
        if(n <= 1){
            return n;
        }

        int []dp = new int[n+1];


        return fib(n-1) + fib(n-2);
    }
}
