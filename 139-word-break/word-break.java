class Solution {
    boolean check(List<String> wordDict, String s){
        for(String i : wordDict){
            if(s.equals(i)) return true;
        }
        return false;
    }
    boolean solve(String s, List<String> wordDict, int start, Boolean[] dp){
        if(start == s.length()) return true;
        
        if(dp[start] != null) return dp[start];

        String word = "";
        boolean flag = false;

        for(int i = start; i < s.length(); i++){
            word += s.charAt(i);
            if(check(wordDict, word)){
                if(solve(s, wordDict, i + 1, dp)){
                    dp[start] = true;
                    return dp[start];
                }
            }
        }
        dp[start] = false;
        return false;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, wordDict, 0, dp);
    }
}