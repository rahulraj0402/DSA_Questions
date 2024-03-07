package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class FindTheTownJudge {
    public static void main(String[] args) {

    }
    public static int findJudge(int n, int[][] trust) {
        if (trust.length == 0){
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer , Integer> map = new HashMap<>();

        // store every value in set
        for (int i = 0 ; i < trust.length ; i++){
            set.add(trust[i][0]);
            int key = trust[i][1];

            if (map.containsKey(key)){
                map.put(key , map.get(key)+1);
            }else {
                map.put(key , 1);
            }
        }

        for (int key : map.keySet()){
            if (map.get(key) == n-1 && !set.contains(key)){
                return key;
            }
        }
        return -1;


    }
}
