package Arrays;


//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
public class checkIfTwoStringArraysareEquivalentLeetCode1662 {

    public static void main(String[] args) {


//        word1 = ["ab", "c"], word2 = ["a", "bc"]

        String[] s1 ={"ab", "c"};
        String[] s2 ={"a", "bc"};

        System.out.println(arrayStringsAreEqual(s1,s2));

    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";

        for (int i = 0 ; i < word1.length ; i++){
            s1 += word1[i];

        }
        for (int i = 0 ; i < word2.length ; i++){
            s2 += word2[i];

        }

        if (s1.equals(s2)){
            return true;
        }
        return false;
    }
}
