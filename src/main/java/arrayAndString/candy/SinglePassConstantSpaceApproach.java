package arrayAndString.candy;

// Single pass approach or Slope Approach - O(n) time and O(1) space

public class SinglePassConstantSpaceApproach {
	public int candy(int[] ratings) {
        int n = ratings.length;
        int minimumCandies = n;

        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i-1]) {
                i++;
                continue;
            }
            
            // Increasing slope
            int incRating = 0;
            while (i < n && ratings[i] > ratings[i-1]) {
                incRating++;
                minimumCandies += incRating;
                i++;
                if (i == n) {
                    return minimumCandies;
                }
            }

            // Dereasing slope
            int decRating = 0;
            while (i < n && ratings[i] < ratings[i-1]) {
                decRating++;
                minimumCandies += decRating;
                i++;
            }

            // Adjust for the peak if there's an overlap
            minimumCandies -= Math.min(incRating, decRating);
        }
        return minimumCandies;
    }
}
