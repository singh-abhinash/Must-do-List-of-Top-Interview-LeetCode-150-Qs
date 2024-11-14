package bitManipulation.numOf1Bits;

/**
 * Optimized Approach using Brian Kernighan's Algorithm:
 * -> In this approach, instead of shifting one bit at a time, we clear the rightmost set bit in each iteration. 
 * This allows us to skip over all 0s in between, making it faster when there are fewer set bits.
 * 
 * Complexity:
 * -> Time Complexity: O(k), where k is the number of set bits in n. This is typically faster than the basic approach 
 * for sparse numbers.
 * -> Space Complexity: O(1).
 * 
 * Example Walkthrough for n=11:
 * n=11 (binary 1011), count = 0
 * n = n & (n - 1): n = 1011 & 1010 → n = 1010, count = 1
 * n = n & (n - 1): n = 1010 & 1001 → n = 1000, count = 2
 * n = n & (n - 1): n = 1000 & 0111 → n = 0000, count = 3
 */
class OptimizedApproach {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // Clear the rightmost set bit
            count++;
        }
        return count;
    }
}

