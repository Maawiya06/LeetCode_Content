class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;
        int m = 2 * n;

        int[] dp1 = new int[m + 1];
        int[] dp2 = new int[m + 1];

        for (int i = 0; i < m; i++) {
            char expect1 = (i % 2 == 0) ? '0' : '1';
            char expect2 = (i % 2 == 0) ? '1' : '0';

            dp1[i + 1] = dp1[i] + (t.charAt(i) != expect1 ? 1 : 0);
            dp2[i + 1] = dp2[i] + (t.charAt(i) != expect2 ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i + n <= m; i++) {
            int flips1 = dp1[i + n] - dp1[i];
            int flips2 = dp2[i + n] - dp2[i];
            ans = Math.min(ans, Math.min(flips1, flips2));
        }

        return ans;
    }
}