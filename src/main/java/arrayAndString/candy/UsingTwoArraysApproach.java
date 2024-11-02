package arrayAndString.candy;

import java.util.Arrays;

//Using Two arrays approach - O(n) time and O(n) space

public class UsingTwoArraysApproach {
	public int candy(int[] ratings) {
        int n = ratings.length;
        int minimumCandies = 0;

        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                leftToRight[i] = leftToRight[i-1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] >= ratings[i+1]) {
                rightToLeft[i] = rightToLeft[i+1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            minimumCandies += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return minimumCandies;
    }
}
