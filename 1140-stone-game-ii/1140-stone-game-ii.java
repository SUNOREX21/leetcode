import java.util.HashMap;
import java.util.Map;

class Solution {
    private int n;
    private int[] suffix;
    private Map<Integer, Integer> memo = new HashMap<>();

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n + 1];               // suffix[i] = sum of piles[i..n-1]
        for (int i = n - 1; i >= 0; i--)
            suffix[i] = suffix[i + 1] + piles[i];
        return dp(0, 1);
    }

    private int dp(int i, int m) {
        if (i >= n) return 0;
        if (i + 2 * m >= n) return suffix[i];   // can grab everything left
        int key = i * (n + 1) + m;              // encode (i, m) as one int
        if (memo.containsKey(key)) return memo.get(key);

        int best = 0;
        for (int x = 1; x <= 2 * m; x++)        // opponent's best; I get the complement
            best = Math.max(best, suffix[i] - dp(i + x, Math.max(m, x)));

        memo.put(key, best);
        return best;
    }
}