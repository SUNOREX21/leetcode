class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(positions[a], positions[b]));

        int[] hp = healths.clone();
        Deque<Integer> stack = new ArrayDeque<>();   // indices of surviving 'R' robots

        for (int k = 0; k < n; k++) {
            int i = idx[k];
            if (directions.charAt(i) == 'R') { stack.push(i); continue; }
            while (!stack.isEmpty() && hp[i] > 0) {  // 'L' robot fights everything to its left
                int j = stack.peek();
                if (hp[j] > hp[i])      { hp[j]--; hp[i] = 0; }
                else if (hp[j] < hp[i]) { hp[i]--; hp[j] = 0; stack.pop(); }
                else                    { hp[i] = 0; hp[j] = 0; stack.pop(); }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) if (hp[i] > 0) res.add(hp[i]);
        return res;
    }
}