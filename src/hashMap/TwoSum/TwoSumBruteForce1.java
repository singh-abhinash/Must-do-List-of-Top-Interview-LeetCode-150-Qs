package hashMap.TwoSum;

public class TwoSumBruteForce1 {

	public int[] twoSum(int[] nums, int target) {
		
        // Iterate over each element in the array as the first element in the pair
        for (int i = 0; i < nums.length; i++) {
            
            // For each element at index i, iterate over the remaining elements
            // to find the second element in the pair
            for (int j = i + 1; j < nums.length; j++) {
                
                // Check if the sum of nums[i] and nums[j] equals the target
                if (nums[i] + nums[j] == target) {
                    
                    // If we find such a pair, return the indices of these elements
                    return new int[]{i, j};
                }
            }
        }
        
        // If no such pair is found, return an array {-1, -1}
        // (this indicates no solution exists in the input array)
        return new int[]{-1, -1};
    }

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Time Complexity:
 * The outer loop runs n times, where n is the length of the nums array.
 * The inner loop runs (n - i - 1) times, which leads to a total of n * (n - 1) / 2 iterations.
 * Overall Time Complexity: O(n^2).
 * 
 * Space Complexity:
 * The space complexity is O(1) because the algorithm only uses a constant amount of extra space for variables and 
 * the return array.
 */
