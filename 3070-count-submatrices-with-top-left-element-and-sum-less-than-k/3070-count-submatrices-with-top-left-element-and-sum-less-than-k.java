class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[] cols = new int[n];   // cols[j] = sum of column j down to current row
        int count = 0;
        for (int i = 0; i < m; i++) {
            int rowRunning = 0;    // running sum across this row of the column-sums
            for (int j = 0; j < n; j++) {
                cols[j] += grid[i][j];
                rowRunning += cols[j];   // = sum of submatrix (0,0)..(i,j)
                if (rowRunning <= k) count++;
            }
        }
        return count;
    }
}