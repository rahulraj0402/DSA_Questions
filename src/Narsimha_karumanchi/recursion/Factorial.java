package Narsimha_karumanchi.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static long factorial(int n ){
        // base case : where the recursion call stops
        if (n == 1 || n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
}
