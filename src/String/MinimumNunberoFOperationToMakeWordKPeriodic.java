package String;

import javax.swing.*;
import java.util.HashMap;

public class MinimumNunberoFOperationToMakeWordKPeriodic {
    public static void main(String[] args) {

    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        int n = word.length();
        int result = 0 ;
        for (int i = 0 ; i < n ; i += k){
            String temp = word.substring(i , Math.min(i + k , n));
            map.put(temp , map.getOrDefault(temp , 0) + 1);
        }
        int max = 0 ;

        // get the substring which is repeated most | in our case for
        // leetcodeleet | leet = 2 | code = 1
        for (int i : map.values()){
            max = Math.max(max , i);
        }
        result = (n / k) - max;
        return result ;
    }
}
