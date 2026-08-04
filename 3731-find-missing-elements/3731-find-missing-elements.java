class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean[] seen = new boolean[201];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums) {
            seen[x] = true;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        List<Integer> res = new ArrayList<>();
        for (int v = min; v <= max; v++) {
            if (!seen[v]) res.add(v);
        }
        return res;
    }
}