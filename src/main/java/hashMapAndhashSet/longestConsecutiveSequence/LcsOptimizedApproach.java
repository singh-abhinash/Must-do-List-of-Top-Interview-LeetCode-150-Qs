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
