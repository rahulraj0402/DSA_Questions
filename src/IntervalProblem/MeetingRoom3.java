package IntervalProblem;

import java.util.Arrays;

public class MeetingRoom3 {
    public static void main(String[] args) {
        System.out.println("rahul");
    }

    public static int mostBooked(int n, int[][] meetings) {
        long []roomAvailabilityTime = new long[n];
        int []meetingCount = new int[n];

        Arrays.sort(meetings , (a, b) -> Integer.compare(a[0],b[0]));

        for (int [] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];

            long minRoomAvailabilityTime = Long.MAX_VALUE;
            int minAvailableTimeRoom = 0;

            boolean foundUnusedRoom = false;

            for (int i = 0 ; i < n ; i++){
                if (roomAvailabilityTime[i] < start){
                    foundUnusedRoom = true;
                    meetingCount[i]++;
                    roomAvailabilityTime[i] = end;
                    break;
                }

            }



        }

    }
}
