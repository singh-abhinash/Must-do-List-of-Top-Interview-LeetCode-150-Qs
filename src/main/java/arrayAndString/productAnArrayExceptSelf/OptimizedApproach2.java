package arrayAndString.productAnArrayExceptSelf;


//using O(n) time and O(1) space

class OptimizedApproach2 {
  public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int productArray[] = new int[n];
      int product = 1;
      
      for (int i = 0; i < n; i++) {
          productArray[i] = product;
          product = product * nums[i];
      }

      product = 1;
      for (int i = n-1; i >= 0; i--) {
          productArray[i] = productArray[i] * product;
          product = product * nums[i];
      }

      return productArray;
  }
}