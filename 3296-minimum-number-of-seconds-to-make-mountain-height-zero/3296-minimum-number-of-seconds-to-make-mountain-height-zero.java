class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long lo = 1, hi = 0;
        for (int t : workerTimes) {
            long cand = (long) t * mountainHeight * (mountainHeight + 1) / 2;
            if (cand > hi) hi = cand;
        }
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (can(mid, mountainHeight, workerTimes)) hi = mid; else lo = mid + 1;
        }
        return lo;
    }

    private boolean can(long T, int h, int[] w) {
        long total = 0;
        for (int t : w) {
            long x = (long) ((Math.sqrt(1.0 + 8.0 * ((double) T / (double) t)) - 1.0) / 2.0);
            if (x < 0) x = 0;
            while ((long) t * (x + 1) * (x + 2) / 2 <= T) x++;
            while (x > 0 && (long) t * x * (x + 1) / 2 > T) x--;
            total += x;
            if (total >= h) return true;
        }
        return total >= h;
    }
}