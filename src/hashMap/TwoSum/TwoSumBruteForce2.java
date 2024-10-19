package hashMap.TwoSum;

import java.util.Arrays;

public class TwoSumBruteForce2 {

	public int[] twoSum(int[] nums, int target) {
		
        // Create a 2D array of pairs where each element is an array {num, original_index}
        // This helps us keep track of the original indices after sorting
        int[][] numAndIndex = new int[nums.length][2];
        
        // Populate numAndIndex with the numbers and their corresponding indices
        for (int i = 0; i < nums.length; i++) {
            numAndIndex[i][0] = nums[i]; // store the number
            numAndIndex[i][1] = i;       // store the original index
        }
        
        // Sort the numAndIndex array by the numbers (the first value in each sub-array)
        // Sorting is done using a custom comparator that compares the first element (the number)
        Arrays.sort(numAndIndex, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Initialize two pointers: one at the start and one at the end of the sorted array
        int left = 0;
        int right = nums.length - 1;
        
        // Start the two-pointer approach
        while (left < right) {
            // Calculate the sum of the numbers at the left and right pointers
            int sum = numAndIndex[left][0] + numAndIndex[right][0];
            
            if (sum == target) {
                // If the sum matches the target, return the original indices of these two numbers
                return new int[] {numAndIndex[left][1], numAndIndex[right][1]};
            } else if (sum < target) {
                // If the sum is less than the target, move the left pointer to the right to increase the sum
                left++;
            } else {
                // If the sum is greater than the target, move the right pointer to the left to decrease the sum
                right--;
            }
        }
        
        // If no solution is found, return {-1, -1} to indicate failure
        return new int[]{-1, -1};
    }

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Time Complexity:
 * Creating the numAndIndex array: This takes O(n) time, where n is the number of elements in the input array.
 * Sorting the numAndIndex array: Sorting takes O(n log n) time using the Arrays.sort() method.
 * Two-pointer approach: The while loop processes each element at most once, so this takes O(n) time.
 * Overall Time Complexity: O(n log n) due to the sorting step.
 * 
 * Space Complexity:
 * Extra space for the numAndIndex array: We store an extra array of size n, where each element is a pair of values, 
 * so this requires O(n) space.
 * No additional recursive calls or data structures: The space used by pointers and variables is constant.
 * Overall Space Complexity: O(n).
 */
