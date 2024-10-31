package arrayAndString.productAnArrayExceptSelf;

//Brute force approach - O(n^2) time and O(1) space

class BruteForceApproach {
  public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int productArray[] = new int[n];
      
      for(int i = 0; i < n; i++) {
          int product = 1;
          for(int j = 0; j < n; j++) {
              if(i != j) {
                  product = product * nums[j];
              }
          }
          productArray[i] = product;
      }
      
      return productArray;
  }
}