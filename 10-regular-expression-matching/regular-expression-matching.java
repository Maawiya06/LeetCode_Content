class Solution {

    boolean solve(String s, String p, int si, int pi, int[][] dp) {

        if (si == s.length() && pi == p.length()) return true;

        if (dp[si][pi] != -1) return dp[si][pi] == 1;

        if (si == s.length()) {
            int tempPi = pi;

            while (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                pi += 2;
            }

            boolean res = (pi == p.length());
            dp[si][tempPi] = res ? 1 : 0;
            return res;
        }

        boolean res = false;

        if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {

            boolean caseA = solve(s, p, si, pi + 2, dp);

            boolean caseB = false;
            if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
                caseB = solve(s, p, si + 1, pi, dp);
            }

            res = caseA || caseB;
        }
        else {
            if (pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
                res = solve(s, p, si + 1, pi + 1, dp);
            }
        }

        dp[si][pi] = res ? 1 : 0;
        return res;
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, p, 0, 0, dp);
    }
}
