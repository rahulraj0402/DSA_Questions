package String;

public class PalendromicSubstrring {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        if (s.length() == 0){
            return 0;
        }
        int n = s.length();

        int res  = 0;

        char c[] = s.toCharArray();

        for (int i = 0 ; i <n ; i++){
            // centre for odd i , i
            // centre for even i , i+1

            res += isPalindromg(i , i , c);
            res += isPalindromg(i , i+1 , c);
        }

        return res;
    }

    public static int isPalindromg(int s , int e , char []c){
        int count  = 0 ;
        while (s >= 0 && e < c.length  && c[s--] == c[e++]){
            count++;
        }

        return count;
    }
}
