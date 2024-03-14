package Maths;

public class FindThePivotInteger {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

    public static int pivotInteger(int n) {

        int totalSum = n * (n + 1) / 2;
        int leftSum = 0;

        for (int i = 1; i <= n; i++) {

            int rightSum = totalSum - leftSum - i;
            if (rightSum == leftSum){
                return i;
            }

            leftSum+=i;
        }

        return -1;
    }
}
