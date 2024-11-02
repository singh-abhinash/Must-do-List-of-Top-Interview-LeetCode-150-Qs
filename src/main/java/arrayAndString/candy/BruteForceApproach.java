package arrayAndString.candy;

import java.util.Arrays;

//Brute force approach - O(n^2) time and O(n) space

public class BruteForceApproach {
	public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                } else if (i < n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }
            }
        }

        int minimumCandies = 0;
        for (int i = 0; i < n; i++) {
            minimumCandies += candies[i];
        }
        return minimumCandies;
    }
}
