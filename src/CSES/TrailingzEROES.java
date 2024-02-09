package CSES;

import com.sun.jdi.PathSearchingVirtualMachine;

public class TrailingzEROES {
    public static void main(String[] args) {
        int fac = factorial(12);
        System.out.println(fac);
        System.out.println(trailingZeroes(fac));
    }



    // optimise approach

//    public static int trailing(int n){
//        int ans = 0 ;
//
//    }




    // bad approach

    public static int trailingZeroes(int n){
        int count = 0;
        int i = 0;
       while (n > 0){
           if (n % 10 == 0){
               count++;
               n = n/10;
           }else {
               break;
           }

       }

       return count;

    }

    public static int factorial(int n){
        int ans = 1;
        for (int i = 1 ; i <= n ; i++ ){
            ans = ans * i;
        }

        return ans;
    }
}
