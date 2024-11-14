package bitManipulation.numOf1Bits;

/**
 * Brute force Approach - O(logn) time and O(1) space
 * 
 * Complexity:
 * -> Time Complexity: O(logn), where n is the number of bits in the integer. In a 32-bit integer, it would take at 
 * most 32 iterations.
 * -> Space Complexity: O(1) since we only use a constant amount of extra space.
 */
public class BruteForceApproach {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // Increment count if the last bit is 1
            n >>= 1;          // Shift bits to the right
        }
        return count;
    }
}

