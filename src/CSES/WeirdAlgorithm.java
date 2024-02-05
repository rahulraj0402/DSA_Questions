package CSES;

public class WeirdAlgorithm {


//    Consider an algorithm that takes as input a positive integer n. If n is even, the algorithm divides it by two,
//    and if n is odd, the algorithm multiplies it by three and adds one. The algorithm repeats this, until n is one. For example,
//    the sequence for n=3 is as follows:
//

//
//    Example
//    Input:
//            3
//
//    Output:
//            3 10 5 16 8 4 2 1

    public static void main(String[] args) {
        algo(3);
    }

    public static void algo(int n){
        if (n == 1 || n < 1){
            System.out.println(n);
            return;
        }

        System.out.print(n + " ");

        if (n % 2 == 0) {
           algo(n / 2);
        } else {
            algo(3 * n + 1);
        }
    }
}
