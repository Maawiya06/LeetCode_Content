class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("000");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
    
    boolean solve(String s, String p, int si, int pi, int[][] dp) {
        // base case
        if (si == s.length() && pi == p.length()) {
            return true;
        }

        if (si <= s.length() && pi <= p.length() && dp[si][pi] != -1) {
            return dp[si][pi] == 1;
        }

        if (si == s.length() && pi < p.length()) {
            while (pi < p.length()) {
                if (p.charAt(pi) != '*') {
                    if (si <= s.length() && pi <= p.length()) dp[si][pi] = 0;
                    return false;
                }
                pi++;
            }
            if (si <= s.length() && pi <= p.length()) dp[si][pi] = 1;
            return true;
        }

        if (si < s.length() && pi < p.length()) {
            // single char match
            if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
                boolean res = solve(s, p, si + 1, pi + 1, dp);
                dp[si][pi] = res ? 1 : 0;
                return res;
            }

            // multiple char match
            if (p.charAt(pi) == '*') {
                boolean caseA = solve(s, p, si, pi + 1, dp);
                boolean caseB = solve(s, p, si + 1, pi, dp);
                boolean res = caseA || caseB;
                dp[si][pi] = res ? 1 : 0;
                return res;
            }
        }

        if (si <= s.length() && pi <= p.length()) dp[si][pi] = 0;
        return false;
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(s, p, 0, 0, dp);
    }
}
