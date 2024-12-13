package matrix.gameOfLife;

//O(m * n) time and O(1) space
public class Solution {
	public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Iterate through the board to calculate the next state based on the current state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                // Encode next state in the second bit
                if (board[i][j] == 1) {
                    // Cell is live
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 1;  // 1 stays 1 (no change)
                    } else {
                        board[i][j] = 3;  // 11 -> 1 (alive)
                    }
                } else {
                    // Cell is dead
                    if (liveNeighbors == 3) {
                        board[i][j] = 2;  // 10 -> 1 (alive)
                    }
                }
            }
        }

        // Update the board to the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Shift bits to get the next state
            }
        }
    }

    // Helper method to count live neighbors
    private static int countLiveNeighbors(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue; // Skip the current cell itself
                int ni = i + x;
                int nj = j + y;
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && (board[ni][nj] & 1) == 1) {
                    count++; // Count live neighbors
                }
            }
        }
        return count;
    }
}
