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
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, wordDict, 0, dp);
    }
}