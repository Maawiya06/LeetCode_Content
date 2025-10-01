class Solution {
    int solve(List<Integer> nums, int target, int index, int sum, int[][] dp) {
        if (sum == target) {
            return 0; 
        }
        if (index == nums.size() || sum > target) {
            return Integer.MIN_VALUE; 
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        
        int include = solve(nums, target, index + 1, sum + nums.get(index), dp);
        if (include != Integer.MIN_VALUE) {
            include = 1 + include; 
        }

       
        int exclude = solve(nums, target, index + 1, sum, dp);

        dp[index][sum] = Math.max(include, exclude);
        return dp[index][sum];
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(nums, target, 0, 0, dp);
        return (ans < 0) ? -1 : ans;
    }
}
