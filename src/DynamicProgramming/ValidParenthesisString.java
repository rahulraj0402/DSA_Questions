package DynamicProgramming;

public class ValidParenthesisString {

    public static void main(String[] args) {
        String s = "((((((((*****************************************))))))))))))))))))))))))))))))))))))))))))))))))))";
        System.out.println(checkValidString(s));
    }
    public static boolean checkValidString(String s) {
        Boolean [][]memo = new Boolean[101][101];
        return solve(0 , 0 , s , s.length() , memo);
    }

    public static boolean solve(int idx , int open , String s , int n , Boolean [][]memo){
        if (idx == n){
            return open == 0;
        }
        if (memo[idx][open] != null){
            return memo[idx][open];
        }

        boolean isValid = false;

        // lets check for *
        if (s.charAt(idx) == '*'){
            // treated as (
            isValid |= solve(idx + 1 , open+1 , s , n , memo);
            // treated as )
            if (open > 0){
                isValid |= solve(idx + 1 , open -1 , s , n , memo);
            }
            // treated as string | no open incremented or decremented
            isValid |=  solve(idx + 1 , open , s , n , memo);
        }
        else if (s.charAt(idx) == '('){
            isValid |= solve(idx + 1 , open + 1 , s , n , memo);
        }else if (open > 0){
           isValid |= solve(idx+1 , open -1 , s , n , memo);
        }

        memo[idx][open] = isValid;

        return isValid;

    }
}
