package String;

public class RepeatedStringMatch683M {

    // string a = abcd , b = cdabcdab
    // problem : its asking that how many times we shoulf repeat a so , we will get b as a substring of a
    //
    //       running a for loop
    //         repetetion 0 : abcd | no substring
    //         repetetion 1 : abcdabcd | no substring
    //         repetetion 3 : abcdabcdabcd | yes we got the substring | return i + 1 = 3 (no of rep)
    //
    //         the no of for loop will run : lenOfB / lenOfA
    //
    //
    //
    //

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a , b));
    }

    public static int repeatedStringMatch(String a, String b) {
        int minRepetion = b.length() / a.length();

        StringBuilder sb = new StringBuilder(a);

       for (int i = 0 ; i < minRepetion + 2 ; i++){
           if (sb.toString().contains(b)) {
               return i+1;
           }else {
               sb.append(a);
           }
       }
       return -1;
    }

}

