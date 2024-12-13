package matrix.setMatrixZeroes;

/**
 * 1) Initialize Two boolean arrays, rows and cols, are created to track which rows and columns need to be set to zero.
 * 2) First Pass (Scan the matrix): The matrix is scanned to find elements that are zero, and corresponding rows and columns 
 * are marked in the rows and cols arrays.
 * 3) Second Pass (Update matrix): The matrix is iterated again, and if any row or column is marked in rows or cols, the 
 * corresponding element in the matrix is set to zero.
 * 
 * // Outplace: O(noOfRows * noOfColumns) time and O(noOfRows + noOfColumns) space
 */
public class OutplaceExtraSpaceApproach {
	public void setZeroes(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfColumns = matrix[0].length;

        // Arrays to track rows and columns that should be set to zero
        boolean[] rows = new boolean[noOfRows];
        boolean[] cols = new boolean[noOfColumns];

        // Step 1: Scan the matrix to find all zero elements and mark their rows and columns
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true; 
                    cols[j] = true;
                }
            }
        }

        // Step 2: Set the entire row and column to zero based on the marks in rows and cols arrays
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

