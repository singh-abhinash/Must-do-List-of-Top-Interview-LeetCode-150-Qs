package bitManipulation.reverseBits;

//Time complexity O(1), Space complexity is O(1)
public class BitByBitApproach {
	public int reverseBits(int n) {
        int ret = 0, power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >>> 1;
            power -= 1;
        }
        return ret;
    }
}
