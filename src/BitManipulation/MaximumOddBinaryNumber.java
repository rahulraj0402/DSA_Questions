package BitManipulation;

import java.util.Arrays;

public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("0101"));
    }

    public static String maximumOddBinaryNumber(String s) {
        char []ch = s.toCharArray();
        Arrays.sort(ch);
        int i = 0 ;
        int j = s.length()-2;

        while (i <= j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            j--;
            i++;
        }

        return new String(ch);
    }
}
