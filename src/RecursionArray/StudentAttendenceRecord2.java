package RecursionArray;

import java.util.Arrays;

public class StudentAttendenceRecord2 {
    public static void main(String[] args) {
        int n = 10000;
        System.out.println(checkRecord(n));
    }

    static int M  = 1000000007;
    static int t[][][] = new int[100001][2][3];
    public static int checkRecord(int n) {
        for(int i = 0 ; i < 100001 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                Arrays.fill(t[i][j] , -1);
            }
        }

        return solve(n , 0 , 0);
    }

    public static int solve(int n , int absent_count , int late_count){

        // for proning we are writing this code
        if(absent_count >= 2 || late_count >= 3){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        // check is the current value is present in memo array or not
        if(t[n][absent_count][late_count] != -1){
            return t[n][absent_count][late_count];
        }

        int A = solve(n-1,absent_count+1,0);
        int L = solve(n-1, absent_count , late_count+1);
        int P = solve(n-1 , absent_count , 0);

        return t[n][absent_count][late_count] = ((A+L) % M + P) % M ;

    }
}
