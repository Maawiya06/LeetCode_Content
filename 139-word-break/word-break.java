class Solution {
    boolean check(List<String> wordDict, String s){
        for(String i : wordDict){
            if(s.equals(i)) return true;
        }
        return false;
    }
    boolean solve(String s, List<String> wordDict, int start, int[] dp){
        if(start == s.length()) return true;
        
        if(dp[start] != -1) return dp[start] == 1;

        String word = "";
        boolean flag = false;

        for(int i = start; i < s.length(); i++){
            word += s.charAt(i);
            if(check(wordDict, word)){
                flag = flag || solve(s, wordDict, i + 1, dp);
            }
        }
        dp[start] = flag ? 1 : 0;
        return flag;

    }

    // by using BU
    boolean solveBU(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; 

        for(int start = n - 1; start >= 0; start--){
            String word = "";
            boolean flag = false;
            for(int i = start; i < n; i++){
                word += s.charAt(i);
                if(check(wordDict, word) && dp[i + 1]){
                    flag = true;
                    break;
                }
            }
            dp[start] = flag;
        }
        return dp[0];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // int[] dp = new int[s.length()];
        // Arrays.fill(dp, -1);
        // return solve(s, wordDict, 0, dp);

       
        return solveBU(s, wordDict);
    }
}