package matrix.rotateImage;
/**
APPROACH:
TC - O(n^2) and SC - O(1)

Original Matrix
[1, 2, 3]     
[4, 5, 6] 
[7, 8, 9]

Transpose Matrix
[1, 4, 7]
[2, 5, 8]
[3, 6, 9]

Revere the matrix
[7, 4, 1]
[8, 5, 2]
[9, 6, 3]

 */
public class InplaceConstantSpaceApproach {
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
