package matrix.validSuduko;

import java.util.HashSet;

/**
Initialize a HashSet called seen to track unique entries across rows, columns, and 3x3 sub-grids.
Loop through each cell in the 9x9 board; for non-empty cells, generate keys for the row, column, and sub-grid.
If any of these keys are already in the seen set, return false.
If no duplicates are found after scanning the entire board, return true. 

Time Complexity
	• We traverse every cell in a 9x9 grid, which takes O(81) = O(1) since 81 is a constant.
	• Each insertion and lookup in a HashSet takes O(1) time, so overall time is O(1).
Space Complexity
	• The HashSet can contain at most 81 elements.
	• So, space complexity is also O(1) since it's bounded by a constant.
*/
public class Solution {
	public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char current = board[i][j];
                    if (current != '.') {
                        String rowCheck = current + "row check" + i;
                        String colCheck = current + "col check" + j;
                        String gridCheck = current + "grid check" + i/3 + "-" + j/3;

                        if (!seen.add(rowCheck) || !seen.add(colCheck) || !seen.add(gridCheck)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
