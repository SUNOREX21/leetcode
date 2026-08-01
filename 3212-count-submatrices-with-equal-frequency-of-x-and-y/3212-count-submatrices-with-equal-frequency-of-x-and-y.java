class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] colDiff = new int[cols];
        int[] colX = new int[cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            int rowDiff = 0, rowX = 0;
            for (int j = 0; j < cols; j++) {
                char c = grid[i][j];
                int d = 0, x = 0;
                if (c == 'X') { d = 1; x = 1; }
                else if (c == 'Y') { d = -1; }
                colDiff[j] += d;
                colX[j] += x;
                rowDiff += colDiff[j];
                rowX += colX[j];
                if (rowDiff == 0 && rowX > 0) count++;
            }
        }
        return count;
    }
}