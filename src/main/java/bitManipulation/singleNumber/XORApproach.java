package bitManipulation.singleNumber;

public class XORApproach {
	public int singleNumber(int[] nums) {
        int singleNumber = 0;
        // logic behind this is, XOR of a^a^a^......2a = 0
        for (int i = 0; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }
}
