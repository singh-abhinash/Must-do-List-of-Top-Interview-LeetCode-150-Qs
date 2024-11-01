package arrayAndString.trappingRainWater;

//Two Pointers Approach - O(n) time and O(1) approach

class TwoPointerApproach {
 public int trap(int[] height) {
     int leftIndex = 0, rightIndex = height.length - 1;
     int leftMaxHeight = 0, rightMaxHeight = 0;
     int totalTrappedWater = 0;

     while (leftIndex < rightIndex) {
         if (height[leftIndex] < height[rightIndex]) {
             leftMaxHeight = Math.max(leftMaxHeight, height[leftIndex]);
             totalTrappedWater += leftMaxHeight - height[leftIndex];
             leftIndex++;
         } else {
             rightMaxHeight = Math.max(rightMaxHeight, height[rightIndex]);
             totalTrappedWater += rightMaxHeight - height[rightIndex];
             rightIndex--;
         }
     }

     return totalTrappedWater;
 }
}
