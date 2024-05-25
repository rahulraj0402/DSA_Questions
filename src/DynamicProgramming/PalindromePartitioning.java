package DynamicProgramming;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aba";
        List<List<String>> result = partition(s);
        for (List<String> partition : result) {
            System.out.println(partition);
        }


    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(result , new ArrayList<>() , 0 , s);
        return result;
    }

    public static void solve(List<List<String>> result , List<String> temp , int start , String s){

        if (start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start ; end < s.length() ; end++){
            if (isPalindrome(s ,start , end)){
                temp.add(s.substring(start , end+1));

                solve(result , temp , end + 1 , s);

                temp.remove(temp.size()-1);
            }
        }
    }

    // make a function for checking a palindrome
    public static boolean isPalindrome(String s , int start , int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
