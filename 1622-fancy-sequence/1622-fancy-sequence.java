class Fancy {
    static final int MOD = 1000000007;
    private long[] vals = new long[100005];
    private int n = 0;
    private long a = 1, b = 0;

    public Fancy() {
    }

    public void append(int val) {
        long v = ((val - b) % MOD + MOD) % MOD;
        vals[n++] = v * power(a, MOD - 2) % MOD;
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }

    public void multAll(int m) {
        a = a * m % MOD;
        b = b * m % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= n) return -1;
        return (int)((vals[idx] * a + b) % MOD);
    }

    private long power(long x, long y) {
        long r = 1;
        x %= MOD;
        while (y > 0) {
            if ((y & 1) == 1) r = r * x % MOD;
            x = x * x % MOD;
            y >>= 1;
        }
        return r;
    }
}