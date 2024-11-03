package hashmap.containsDuplicateII;

import java.util.HashMap;


// Optimized Approach suing Hashmap - O(n) time and O(n) space
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // stores number and its latest index
        HashMap<Integer, Integer> numIndexMap = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(nums[i])) {
                if (i - numIndexMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            // update the index of the current number
            numIndexMap.put(nums[i], i);
        }
        return false;
    }
}
