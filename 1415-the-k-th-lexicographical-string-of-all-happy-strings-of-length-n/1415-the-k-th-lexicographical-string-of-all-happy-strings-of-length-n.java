class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) return "";
        k--;
        int block = 1 << (n - 1);
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('a' + k / block));
        k %= block;
        for (int i = 1; i < n; i++) {
            block /= 2;
            int idx = k / block;
            k %= block;
            char prev = sb.charAt(sb.length() - 1);
            int cnt = 0;
            for (char c = 'a'; c <= 'c'; c++) {
                if (c == prev) continue;
                if (cnt == idx) { sb.append(c); break; }
                cnt++;
            }
        }
        return sb.toString();
    }
}