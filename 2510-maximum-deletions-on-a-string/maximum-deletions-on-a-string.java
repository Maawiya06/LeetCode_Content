class Solution {
    public int deleteString(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        return dfs(s, 0, dp);
    }

    private int dfs(String s, int start, Integer[] dp) {
        if (start >= s.length()) return 0;
        if (dp[start] != null) return dp[start];

        int n = s.length();
        int maxOps = 1; // Option: delete all remaining at once

        // Try deleting first i letters if they match the next i letters
        for (int i = 1; start + 2*i <= n; i++) {
            if (s.regionMatches(start, s, start + i, i)) {
                maxOps = Math.max(maxOps, 1 + dfs(s, start + i, dp));
            }
        }
        return dp[start] = maxOps;
    }
}