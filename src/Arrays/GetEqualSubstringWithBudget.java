package Arrays;

import java.util.ArrayList;
import java.util.List;

public class GetEqualSubstringWithBudget {

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3 ;

        System.out.println(equalSubstringBruteForce1(s , t, maxCost));
        System.out.println(equalSubstring(s , t , maxCost));

    }

    // sliding window approach
    public static int equalSubstring(String s, String t, int maxCost) {
        int j = 0 ;
        int i = 0 ;
        int maxLength = 0 ;
        int n = s.length();
        int currCost = 0 ;
        while (j < n ){
            currCost += Math.abs(s.charAt(j) - t.charAt(j));


            while (currCost > maxCost){
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }


            maxLength = Math.max(j - i + 1 , maxLength);
            j++;
        }
        return maxLength;
    }

    public static int equalSubstringBruteForce2(String s, String t, int maxCost) {
        int maxLength = 0 ;

        for (int start = 0 ; start < s.length() ; start++){
            int tempCost = 0;
            for (int end = start ; end <= t.length() ; end++){
                tempCost += Math.abs(s.charAt(start) - t.charAt(end));
                if (tempCost > maxCost){
                    break;
                }
                maxLength = Math.max(maxLength , end - start + 1);
            }
        }
        return maxLength;
    }


    public static int equalSubstringBruteForce1(String s, String t, int maxCost) {
        int maxLength = 0;
        // lets find all the substring of s and t and store in an array list
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // finding the substring and storing in list one

        for (int i = 0 ; i < s.length() ; i++){
            for (int j = i+1 ; j <= s.length() ; j++){
                list1.add(s.substring(i , j));
            }
        }

        for (int i = 0 ; i < t.length() ; i++){
            for (int j = i + 1 ; j <= t.length() ; j++){
                list2.add(t.substring(i,j));
            }
        }

        // now we will start comparing two things 1) is for changing it cost <= maxCost if it so then
        // we will take the max length


        for (String temp1 : list1){
            for (String temp2 : list2){
                int tempCost = 0 ;
                if (temp1.length() == temp2.length()){
                    for (int k = 0 ; k < temp1.length() ; k++){
                        tempCost += Math.abs(temp1.charAt(k) - temp2.charAt(k));

                    }
                    if (tempCost <= maxCost){
                        maxLength = Math.max(maxLength , temp1.length());
                    }
                }
            }
        }

        return maxLength;

    }
}
