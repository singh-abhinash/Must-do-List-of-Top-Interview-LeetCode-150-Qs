package intervals.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Out-of Place - O(nlogn) time and O(1) space
public class OutOfPlaceSolution {
	public int[][] merge(int[][] intervals) {
        List<int[]> output = new ArrayList<>();
        
        // Sort intervals based on the first element
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Add the first interval to the output list
        output.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = output.get(output.size() - 1);

            // Check if the current interval overlaps with the last interval in output
            if (lastInterval[1] >= intervals[i][0]) {
                // Merge the intervals by updating the end time
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                // No overlap, so add the current interval to the output
                output.add(intervals[i]);
            }
        }
        
        // Convert the List<int[]> to int[][] for the return type
        return output.toArray(new int[output.size()][]);
    }
}
