package String;

public class FindMinimumLengthOfStringAfterDeletingSimilarchar {
    public static void main(String[] args) {
       String s =  "cabaabac";
        System.out.println(minimumLength(s));
    }
    public static int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        if (left >= right) // String is empty or all characters are similar
            return 0;

        return right - left + 1;
    }
}
