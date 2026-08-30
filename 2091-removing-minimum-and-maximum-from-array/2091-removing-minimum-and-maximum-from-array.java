class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length, i = 0, j = 0;
        for (int k = 0; k < n; k++) {
            if (nums[k] < nums[i]) i = k;
            if (nums[k] > nums[j]) j = k;
        }
        int lo = Math.min(i, j), hi = Math.max(i, j);
        return Math.min(hi + 1, Math.min(n - lo, (lo + 1) + (n - hi)));
    }
}