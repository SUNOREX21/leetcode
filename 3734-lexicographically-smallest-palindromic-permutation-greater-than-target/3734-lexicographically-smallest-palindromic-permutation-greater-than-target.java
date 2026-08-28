class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        int oddIdx = -1, oddCnt = 0;
        for (int i = 0; i < 26; i++) if (cnt[i] % 2 == 1) { oddCnt++; oddIdx = i; }
        if (n % 2 == 0 ? oddCnt != 0 : oddCnt != 1) return "";
        String mid = (n % 2 == 1) ? String.valueOf((char)('a' + oddIdx)) : "";

        int m = n / 2;
        int[] avail = new int[26];
        for (int i = 0; i < 26; i++) avail[i] = cnt[i] / 2;

        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = target.charAt(i) - 'a';

        int[] pref = new int[m];
        int L = 0;
        while (L < m && avail[t[L]] > 0) { avail[t[L]]--; pref[L] = t[L]; L++; }

        if (L == m) {
            String cand = build(pref, m, mid);
            if (cand.compareTo(target) > 0) return cand;
        }
        for (int i = Math.min(L, m - 1); i >= 0; i--) {
            while (L > i) { L--; avail[pref[L]]++; }   // roll prefix back to length i
            for (int c = t[i] + 1; c < 26; c++) {
                if (avail[c] > 0) {
                    avail[c]--;
                    int[] half = new int[m];
                    System.arraycopy(pref, 0, half, 0, i);
                    half[i] = c;
                    int p = i + 1;
                    for (int d = 0; d < 26; d++)
                        for (int k = 0; k < avail[d]; k++) half[p++] = d;
                    return build(half, m, mid);
                }
            }
        }
        return "";
    }

    private String build(int[] half, int m, String mid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) sb.append((char)('a' + half[i]));
        String h = sb.toString();
        return h + mid + new StringBuilder(h).reverse();
    }
}