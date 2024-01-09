package String;

public class DetectCapital {
    public static void main(String[] args) {

    }

    public boolean detectCapitalUse(String word) {

        int caps = 0 ;  // this will keep count of capital letter
        int low = 0 ;  // this will keep count of lower case
        int first = 0 ;  // this will keep count of first letter

        for(char ch : word.toCharArray()){
            if (ch >= 65 && ch <= 90){
                // if this is the case then it means it falls in capoital letter
                caps++;
                if (first == 0){
                    first = 1;
                }
            }else {
                low++;
                if (first == 0){
                    first = 2; // first = 2 indicates that first letter is not Capital | example = leetcode
                }
            }
        }

        if (caps == 0 || low == 0 || first ==1 && caps==1)
            return true;
        else
            return false;



    }
}

