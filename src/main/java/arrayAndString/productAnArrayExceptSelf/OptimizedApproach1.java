package arrayAndString.productAnArrayExceptSelf;


//using suffix and prefix array, O(n) time and O(n) space

class OptimizedApproach1 {
  public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
  
      int prefixProduct[] = new int[n];
      prefixProduct[0] = 1;
      for (int i = 1; i < n; i++) {
          prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
      }

      int suffixProduct[] = new int[n];
      suffixProduct[n-1] = 1;
      for (int i = n-2; i >= 0; i--) {
          suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
      }

      int productArray[] = new int[n];
      for (int i = 0; i < n; i++) {
          productArray[i] = suffixProduct[i] * prefixProduct[i];
      }

      return productArray;
  }
}