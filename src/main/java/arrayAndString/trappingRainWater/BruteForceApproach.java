package arrayAndString.trappingRainWater;

//Brute force approach - O(n^2) time and O(1) space

class BruteForceApproach {
  public int trap(int[] height) {
      int n = height.length;
      int totalTrappedWater = 0;
      for (int i = 0; i < n; i++) {
          int leftMaxHeight = 0, rightMaxHeight = 0;
          
          //finding maximum height till 0 to i
          for (int j = 0; j <= i; j++) {
              leftMaxHeight = Math.max(leftMaxHeight, height[j]);
          }

          //finding maximum height till i to n-1
          for (int j = i; j <= n-1; j++) {
              rightMaxHeight = Math.max(rightMaxHeight, height[j]);
          }

          // Water stored at this height i
          totalTrappedWater += Math.min(leftMaxHeight, rightMaxHeight) - height[i];
      }
      return totalTrappedWater;
  }
}
