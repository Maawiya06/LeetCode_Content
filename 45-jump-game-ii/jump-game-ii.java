class Solution {
    int solve(int i, int[] nums, int[] dp){
        int n = nums.length;
        // base case
        if(i == n - 1) return 0;

        if(nums[i] == 0) return Integer.MAX_VALUE;

        if(dp[i] != -1){
            return dp[i];
        }
        
        int minjump = Integer.MAX_VALUE;
        for(int step = 1; step <= nums[i] && i + step < n; step++){
            int next = solve(i + step, nums, dp);
            if(next != Integer.MAX_VALUE){
                minjump = Math.min(minjump, 1 + next);
            }
        }
        dp[i] = minjump;
        return dp[i];
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp,-1);
        int ans = solve(0, nums, dp);
        return ans;
    }
}