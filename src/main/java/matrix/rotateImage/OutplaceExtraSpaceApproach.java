package matrix.rotateImage;

//If we are using extra space then matrix[i][j] is shifting to matrix[j][n - 1 - i];
//This is the only Approach for out-place
//TC is O(n^2) and SC is O(n^2)
public class OutplaceExtraSpaceApproach {
	public void rotate(int[][] matrix) {
        int n = matrix.length;

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
