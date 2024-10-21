package hashMapAndhashSet.longestConsecutiveSequence;

import java.util.Arrays;

public class LcsBruteForceApproach {
	public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        int longestConsecSeq = 1, currLongestConsecSeq = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i+1]) {
                currLongestConsecSeq += 1;
                longestConsecSeq = Math.max(longestConsecSeq, currLongestConsecSeq);
            } else {
                currLongestConsecSeq = 1;
            }
        }
        return longestConsecSeq;
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Time Complexity:
 * -> Sorting the array: The code uses Arrays.sort(nums), which sorts the array in O(n log n) time, where n is the 
 * number of elements in the array.
 * -> Iterating through the array: The for loop iterates over the array once, which takes O(n) time.
 * -> Since sorting is the most time-consuming operation, the overall time complexity is: O(n log n).
 * 
 * Space Complexity:
 * -> Sorting: If Arrays.sort() performs in-place sorting (which it does for primitive types like int[]), the space 
 * complexity for sorting is O(1).
 * -> Auxiliary variables: The variables longestConsecSeq and currLongestConsecSeq use a constant amount of space, i.e., O(1).
 * -> Thus, the overall space complexity is:O(1) (if sorting is in-place).
 * -> However, if Arrays.sort() uses additional space for sorting (e.g., mergesort), the space complexity could be O(n).
 * 
 * Summary:
 * -> Time complexity: O(n log n).
 * -> Space complexity: O(1) (assuming in-place sorting), or O(n) if extra space is used during sorting.
 */
