package RecursionArray;

import java.util.EventListener;
import java.util.Locale;

public class StudentAttendenceRecord1 {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        int absent_count = 0 ;
        int n = s.length();
       for (int i = 0 ; i < s.length() ; i++){
           char ch = s.charAt(i);
           if (ch == 'A') absent_count++;
           else if (ch == 'L' && i < n-2){
                if (s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L') return false;
           }
       }

       if (absent_count > 1) return false;
       return true;
    }
}
