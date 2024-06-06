package IntervalProblem;

import java.util.HashSet;
import java.util.Set;

public class CountDaysWithoutMeeting {
    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        System.out.println(countDays(days , meetings));

    }

    public static int countDays(int days, int[][] meetings) {
        Set<Integer> set = new HashSet<>();
        int count = 0 ;
        for (int []meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];

            for (int day = start ; day <= end ; day++){
                set.add(day);
            }
        }

        for (int i = 1 ; i <= days ; i++){
            if (!set.contains(i)){
                count++;
            }
        }
        return count;
    }
}
