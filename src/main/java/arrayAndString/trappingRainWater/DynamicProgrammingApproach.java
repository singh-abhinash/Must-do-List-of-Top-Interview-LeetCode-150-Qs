package arrayAndString.trappingRainWater;

//Dynamic Programming Approach - O(n) time and O(n) space

class DynamicProgrammingApproach {
 public int trap(int[] height) {
     int n = height.length;
     if (n == 0) 
         return 0;

     int totalTrappedWater = 0;

     // Create arrays to store the max height to the left and right of each index
     int[] leftMaxHeight = new int[n];
     int[] rightMaxHeight = new int[n];

     // Fill leftMaxHeight array
     leftMaxHeight[0] = height[0];
     for (int i = 1; i < n; i++) {
         leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i]);
     }

     // Fill rightMaxHeight array
     rightMaxHeight[n - 1] = height[n - 1];
     for (int i = n - 2; i >= 0; i--) {
         rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i]);
     }

     // Calculate the trapped water at each index
     for (int i = 0; i < n; i++) {
         totalTrappedWater += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
     }

     return totalTrappedWater;
 }
}