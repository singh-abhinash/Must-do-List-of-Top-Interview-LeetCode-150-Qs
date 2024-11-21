package binarySearch.findPeakElement;

//Brute force approach - O(n) time and O(1) space
public class BruteForceLinerApproach {
	public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i] > nums[i - 1]) &&
                (i == n - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1; // This will never happen as there is always a peak
    }
}
