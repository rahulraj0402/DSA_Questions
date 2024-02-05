package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()){
            return "";
        }

        // this mapT will store the occurence of string t
        Map<Character,Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()){
            int count  = mapT.getOrDefault(c,0);
            mapT.put(c , count+1);
        }


        // we need at least the number of character present in t
        int required = mapT.size();
        int l , r = 0;

        int formed  = 0;


        // this window count will be keep track of current window

//        Map<Character , Integer>
        return "";
    }
}
