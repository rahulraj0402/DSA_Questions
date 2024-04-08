package String;

import java.lang.reflect.Array;
import java.util.Arrays;

public class IsomorphicString {
    public static void main(String[] args) {

        String s = "egg", t = "add";

        System.out.println(isIsomorphic(s , t));

    }

    public static boolean isIsomorphic(String s, String t) {

        int []map1 = new int[256];
        int []map2 = new int[256];

       // initialize the arrays by -1

        Arrays.fill(map1 , -1);
        Arrays.fill(map2, -1);

        // lets get the length of an string

        int n = s.length();

        for (int i = 0 ; i < n ; i++){

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if ((map1[i] == -1 && map1[i] != map2[i]) ||
                    (map2[i] == -1 && map2[i] != map1[i])){
                return false;
            }

            // aff the mapping
            map1[i] = ch2;
            map2[i] = ch1;

        }


        return true;

    }
}
