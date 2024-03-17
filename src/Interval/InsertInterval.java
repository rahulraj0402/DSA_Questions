package Interval;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int [][]res = insert(intervals , newInterval);

        printMatrix(res);

    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        // Create a list to hold the merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        // Add all intervals that end before the newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        // Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);
        // Add remaining intervals
        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Convert list to array
        int[][] result = new int[mergedIntervals.size()][2];
        for(int j = 0; j < mergedIntervals.size(); j++) {
            result[j] = mergedIntervals.get(j);
        }
        return result;
    }
}
