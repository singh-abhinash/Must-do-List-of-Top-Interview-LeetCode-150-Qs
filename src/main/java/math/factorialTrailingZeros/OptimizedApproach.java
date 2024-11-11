package math.factorialTrailingZeros;

//Optimized Approach - O(logn) time and O(1) space;
class OptimizedApproach {
 public int trailingZeroes(int n) {
     int countTrailZeros = 0;
     
     // Count factors of 5, 25, 125, ...
     while (n >= 5) {
         n /= 5;  // Divide n by powers of 5
         countTrailZeros += n;
     }
     
     return countTrailZeros;
 }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * INTUITION BEHIND THE PROBLEM:
 * Instead of calculating the entire factorial, we can find how many times n! is divisible by 10 by counting the 
 * number of factors of 5 in the numbers from 1 to n. This works because there will always be more factors of 
 * 2 than 5 in the factorial, so the number of trailing zeroes is determined by the number of 5s in the factorization.
 * 
 * To count how many multiples of 5, 25, 125, etc., there are from 1 to n:
 * Count how many numbers are divisible by 5.
 * Count how many numbers are divisible by 25 (since each contributes an extra factor of 5).
 * Continue counting for 125, 625, and so on, until the divisor exceeds n.
 * Each multiple of 5 contributes at least one factor of 5 to the factorial, each multiple of 25 contributes at least 
 * two factors of 5, and so on.
 * 
 * For Example:
 * If n = 100:
 * 100 / 5 = 20 (there are 20 numbers divisible by 5)
 * 100 / 25 = 4 (there are 4 numbers divisible by 25, each contributing an additional factor of 5)
 * 100 / 125 = 0 (there are no numbers divisible by 125)
 * Total trailing zeros = 20 + 4 = 24.
 */