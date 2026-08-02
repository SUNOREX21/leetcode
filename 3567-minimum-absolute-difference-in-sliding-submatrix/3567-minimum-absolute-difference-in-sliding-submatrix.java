class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int rows = m - k + 1, cols = n - k + 1;
        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        set.add(grid[x][y]);
                    }
                }
                if (set.size() == 1) {
                    ans[i][j] = 0;
                } else {
                    int minDiff = Integer.MAX_VALUE;
                    Integer prev = null;
                    for (int v : set) {
                        if (prev != null) minDiff = Math.min(minDiff, v - prev);
                        prev = v;
                    }
                    ans[i][j] = minDiff;
                }
            }
        }
        return ans;
    }
}