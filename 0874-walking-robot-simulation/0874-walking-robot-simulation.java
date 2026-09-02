class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        java.util.Set<Long> blocked = new java.util.HashSet<>();
        for (int[] o : obstacles) {
            blocked.add((long) o[0] * 100000L + o[1]);
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0, x = 0, y = 0, best = 0;
        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d + 3) % 4;
            } else {
                for (int s = 0; s < c; s++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (blocked.contains((long) nx * 100000L + ny)) break;
                    x = nx;
                    y = ny;
                }
                best = Math.max(best, x * x + y * y);
            }
        }
        return best;
    }
}