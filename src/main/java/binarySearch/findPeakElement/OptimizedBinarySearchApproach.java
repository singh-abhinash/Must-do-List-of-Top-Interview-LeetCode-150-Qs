package binarySearch.findPeakElement;

//Optimized approach - O(logn) time and O(1) space
public class OptimizedBinarySearchApproach {
	public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // Peak lies in the left half
                right = mid;
            } else {
                // Peak lies in the right half
                left = mid + 1;
            }
        }
        return left; // or right, as both will point to the same index
    }
}
