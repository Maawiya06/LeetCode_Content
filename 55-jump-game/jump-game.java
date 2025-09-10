class Solution {
    int[] dp;

    private boolean solve(int i, int[] nums) {
        int n = nums.length;

        // Base case: if already at last index
        if (i == n - 1) return true;

        // Out of bounds or stuck
        if (nums[i] == 0) return false;

        // If already solved
        if (dp[i] != -1) return dp[i] == 1;

        // Try all jumps from this index
        for (int step = 1; step <= nums[i] && i + step < n; step++) {
            if (solve(i + step, nums)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums);
    }
}
