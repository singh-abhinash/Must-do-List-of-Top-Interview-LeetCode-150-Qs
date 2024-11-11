package math.factorialTrailingZeros;

//Brute force approach - O(nlogn) time and O(nlogn) space
class BruteForceApproach {
 public int trailingZeroes(int n) {
     long fact = 1;
     
     // Calculate the factorial
     for (int i = 1; i <= n; i++) {
         fact *= i;
     }
     
     // Count the trailing zeroes
     int count = 0;
     while (fact % 10 == 0) {
         count++;
         fact /= 10;
     }
     
     return count;
 }
}
/**
* Time Complexity:
* The brute force approach involves two major steps:
* 
* Calculating n!:
* To calculate n!, you need to multiply all the numbers from 1 to n. This step takes O(n) time because you're 
* performing n multiplications to compute the factorial.
* 
* Counting Trailing Zeroes:
* Once the factorial is computed, you count the number of trailing zeroes by repeatedly dividing the factorial by 10. 
* The number of times you divide by 10 is proportional to the number of digits in the factorial. Since n! grows 
* extremely fast, the number of digits is approximately O(n log n), as n! has about n log n digits in base 10 
* (this is a rough estimate using Stirling's approximation).
* 
* Thus, the overall time complexity is the sum of the time for calculating the factorial and the time for counting 
* the trailing zeroes.
* 
* Time Complexity = O(n) (for computing n!) + O(n log n) (for counting trailing zeroes)
* 
* Since the factorial grows rapidly, the O(n log n) term dominates, so the overall time complexity is O(n log n).
* 
* Space Complexity:
* In the brute force approach, the main space usage comes from storing the computed factorial. The space required to 
* store the factorial grows with the number of digits in the result.
* 
* Factorial Storage: The factorial n! grows extremely large as n increases, and the number of digits in n! is 
* proportional to O(n log n).
* 
* To store a large number like n!, you need O(n log n) space to store the digits, which is the space required.
* Auxiliary Space: Other variables like fact and count require constant space, O(1).
* 
* Thus, the space complexity is dominated by the storage required to hold the factorial result.
* Space Complexity = O(n log n) (for storing n!).
* 
* CONCLUSION:
* Time Complexity: O(n log n) — This is due to calculating the factorial and then counting the number of trailing 
* zeroes in the factorial.
* Space Complexity: O(n log n) — This is due to the space needed to store the large number resulting from n!.
*/
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++