package hashMap.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOptimizedApproach {

	public int[] twoSum(int[] nums, int target) {
		
        // Create a HashMap to store numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i]; // Find the difference of the current number
            
            // Check if the difference is already in the HashMap
            if (map.containsKey(difference)) {
                // If difference exists, return the indices
                return new int[] {map.get(difference), i};
            }
            
            // If difference does not exist, add the current number and its index to the HashMap
            map.put(nums[i], i);
        }
        
        // The problem guarantees that there will always be a solution, so this will never be reached
        return new int[] {-1, -1};
    }

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Time Complexity:
 * -> Iteration over the array: The algorithm goes through the nums array once, performing O(1) operations (HashMap insertion 
 * and lookup) at each step.
 * -> The loop runs for n elements, so this part takes O(n) time.
 * -> HashMap operations: Both map.containsKey() and map.put() are O(1) on average, due to the constant-time complexity of 
 * HashMap operations.
 * -> Thus, the overall time complexity is: O(n), where n is the number of elements in the nums array.
 * 
 * Space Complexity:
 * -> HashMap space usage: In the worst case, the HashMap stores all n elements if no two numbers add up to the target 
 * until the very last pair. Therefore, the space required for the HashMap is O(n).
 * -> Auxiliary space: Apart from the HashMap, we are using constant space for variables like difference, i, and the array 
 * to return the result.
 * Thus, the overall space complexity is:O(n), where n is the number of elements in the nums array.
 * 
 * Summary:
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
