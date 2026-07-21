import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        // Sort by end time
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int remove = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlapping interval
            if (intervals[i][0] < lastEnd) {
                remove++;
            }
            // Non-overlapping interval
            else {
                lastEnd = intervals[i][1];
            }
        }

        return remove;
    }
}