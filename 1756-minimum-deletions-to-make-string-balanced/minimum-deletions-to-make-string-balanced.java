class Solution {
    private int solve(String s, int index, int Bcollect, Integer[][] dp){
        if(index == s.length()) return 0;

        if(dp[index][Bcollect] != null) return dp[index][Bcollect];

        char ch = s.charAt(index);

        int delete = 1 + solve(s, index + 1, Bcollect, dp);
        int ans;

        if(ch == 'a'){
            if(Bcollect == 1){
                ans = Integer.MAX_VALUE;
            }
            else{
                ans = solve(s, index + 1, 0, dp);
            }
        }
        else{
            ans = solve(s, index + 1, 1, dp);
        }
        return dp[index][Bcollect] = Math.min(delete, ans);
    }
    public int minimumDeletions(String s) {
        // int n = s.length();
        // Integer[][] dp = new Integer[n][2];
        // return solve(s, 0, 0, dp);

        // greeedy solution
        int delete = 0;
        int countB = 0;

        for(char found : s.toCharArray()){
            if(found == 'b'){
                countB++;
            }
            else{
                delete = Math.min(delete + 1, countB);
            }
        }
        return delete;
    }
}