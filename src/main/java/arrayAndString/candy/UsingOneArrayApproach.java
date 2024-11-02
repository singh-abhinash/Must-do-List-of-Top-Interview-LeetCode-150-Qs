package arrayAndString.candy;

import java.util.Arrays;

// Using One array approach - O(n) time and O(n) space

public class UsingOneArrayApproach {
	public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int minimumCandies = 0;
        for (int i = 0; i < n; i++) {
            minimumCandies += candies[i];
        }
        return minimumCandies;
    }
}
