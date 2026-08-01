import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == 1 ? heights[j] + 1 : 0;
            }
            int[] sorted = heights.clone();
            Arrays.sort(sorted);
            for (int k = 0; k < n; k++) {
                int width = n - k;
                int height = sorted[k];
                maxArea = Math.max(maxArea, width * height);
            }
        }
        return maxArea;
    }
}