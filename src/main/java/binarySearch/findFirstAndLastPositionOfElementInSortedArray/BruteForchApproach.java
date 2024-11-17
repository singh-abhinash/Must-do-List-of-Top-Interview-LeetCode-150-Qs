package binarySearch.findFirstAndLastPositionOfElementInSortedArray;

//Brute force approach - O(n) time and O(1) space
public class BruteForchApproach {
	public int[] searchRange(int[] nums, int target) {
        int firstPosition = -1;
        int lastPosition = -1;

        // Traverse the array to find the first and last occurrences of target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (firstPosition == -1) {
                    firstPosition = i; // Record the first occurrence
                }
                lastPosition = i; // Update the last occurrence each time we find the target
            }
        }

        return new int[]{firstPosition, lastPosition};
    }
}
