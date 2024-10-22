package hashMapAndhashSet.longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LcsOptimizedApproach {
	public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int longestConsecSeq = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currLongestConsecSeq = 1;
                while (set.contains(num + 1)) {
                    num += 1;
                    currLongestConsecSeq += 1;
                }
                longestConsecSeq = Math.max(longestConsecSeq, currLongestConsecSeq);
            } 
        }
        return longestConsecSeq;
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Time Complexity:
 * => Building the Set: 
 * 		-> The code first iterates over the nums array and inserts each element into a HashSet. Adding an element to a 
 * 		   set takes O(1) on average, and there are n elements. Thus, this step takes O(n) time.
 * => Main Loop (Finding Longest Consecutive Sequence): 
 *      -> The second loop iterates over each element in the set, and for each element, it checks if it is the start of a 
 *         consecutive sequence (!set.contains(num - 1)).
 *      -> If the element is the start of a sequence, it enters a while loop to check for all consecutive 
 *         elements (while (set.contains(num + 1))), incrementing the count until it no longer finds consecutive elements. 
 *         Since each element can only be processed once, the while loop runs at most n times in total.
 * => Therefore, this part of the code also takes O(n) time.
 * Overall Time Complexity: Both building the set and finding the longest consecutive sequence take O(n) time. Thus, 
 * the overall time complexity is O(n).
 * 
 * Space Complexity:
 * -> Set Storage: The HashSet stores up to n unique elements (one for each element in nums). Thus, it requires O(n) space.
 * -> Auxiliary Variables: The code uses a constant amount of additional space for variables like longestConsecSeq and 
 * currLongestConsecSeq, which take O(1) space.
 * -> Overall Space Complexity is O(n).
 * 
 */
