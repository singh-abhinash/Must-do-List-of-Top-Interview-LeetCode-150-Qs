package matrix.setMatrixZeroes;

//Inplace: O(noOfRows * noOfColumns) time and O(1) space
public class InplaceConstantSpaceApproach {
	public void setZeroes(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfColumns = matrix[0].length;
        
        // Flags to check if the first row and first column need to be set to 0
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        
        // Check if the first row contains any 0
        for (int j = 0; j < noOfColumns; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // Check if the first column contains any 0
        for (int i = 0; i < noOfRows; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }
        
        // Use the first row and first column to mark rows and columns to be zeroed
        for (int i = 1; i < noOfRows; i++) {
            for (int j = 1; j < noOfColumns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // Mark the row
                    matrix[0][j] = 0;  // Mark the column
                }
            }
        }
        
        // Set cells to 0 based on marks in the first row and column
        for (int i = 1; i < noOfRows; i++) {
            for (int j = 1; j < noOfColumns; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Set first row to 0 if needed
        if (firstRowZero) {
            for (int j = 0; j < noOfColumns; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Set first column to 0 if needed
        if (firstColumnZero) {
            for (int i = 0; i < noOfRows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
