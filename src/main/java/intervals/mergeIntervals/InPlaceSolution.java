package intervals.mergeIntervals;

import java.util.Arrays;

//In Place - O(nlogn) time and O(1) space
public class InPlaceSolution {
	public int[][] merge(int[][] intervals) {
        // Sort intervals based on the first element
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int index = 0; // This will track the position of the merged intervals in-place
        
        for (int i = 1; i < intervals.length; i++) {
            // Check if the current interval overlaps with the last merged interval
            if (intervals[index][1] >= intervals[i][0]) {
                // Merge intervals by updating the end of the current merged interval
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                // Move to the next position and set it as the new interval
                index++;
                intervals[index] = intervals[i];
            }
        }
        
        // Return the merged intervals up to the index position
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }
}
