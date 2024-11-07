package twoPointer.twoSum2InputArrayIsSorted;

// It is given in the problem that arrays is sorted then we can directly use
// Two Pointer Approach - O(n) time and O(1) space
public class TwoPinterApproachSolution {
	public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0, rightIndex = numbers.length-1;
        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                return new int[] {leftIndex + 1, rightIndex + 1};
            } else if (numbers[leftIndex] + numbers[rightIndex] < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return new int[] {-1, -1};
    }
}
