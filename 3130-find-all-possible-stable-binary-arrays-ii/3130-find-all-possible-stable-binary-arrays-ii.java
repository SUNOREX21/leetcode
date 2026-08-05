class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = 1000000007;
        long[][] dp0 = new long[zero + 1][one + 1];
        long[][] dp1 = new long[zero + 1][one + 1];
        for (int i = 1; i <= zero; i++) dp0[i][0] = (i <= limit) ? 1 : 0;
        for (int j = 1; j <= one; j++) dp1[0][j] = (j <= limit) ? 1 : 0;
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                long a = dp0[i - 1][j] + dp1[i - 1][j];
                if (i - limit - 1 >= 0) a -= dp1[i - limit - 1][j];
                dp0[i][j] = ((a % MOD) + MOD) % MOD;
                long b = dp1[i][j - 1] + dp0[i][j - 1];
                if (j - limit - 1 >= 0) b -= dp0[i][j - limit - 1];
                dp1[i][j] = ((b % MOD) + MOD) % MOD;
            }
        }
        return (int) ((dp0[zero][one] + dp1[zero][one]) % MOD);
    }
}