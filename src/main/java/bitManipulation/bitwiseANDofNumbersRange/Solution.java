package bitManipulation.bitwiseANDofNumbersRange;

//First thing is {x << y = x * (2^y)} and {x >> y = x / (2^y)}
//For any confusion check out tech dose video
//time complexity - O(logn) and space complexity - O(1)
class Solution {
 public int rangeBitwiseAnd(int left, int right) {
     int shift = 0;
     while (left < right) {
         left >>= 1;
         right >>= 1;
         shift++;
     }
     left <<= shift;
     return left;
 }
}