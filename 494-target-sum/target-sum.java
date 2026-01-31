class Solution {
    private int solve(int[] nums, int s){
        int[] dp = new int[s + 1];
        dp[0] = 1;

        for(int num : nums){
            for(int j = s; j >= num; j--){
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[s];
    }
    // private int solve(int[] nums, int i, int target, int sum){
    //     if(i >= nums.length) return sum == target ? 1 : 0;

    //     int subs = solve(nums, i + 1, target, sum - nums[i]);
    //     int add = solve(nums, i + 1, target, sum + nums[i]);
    //     return subs + add;
    //}
    public int findTargetSumWays(int[] nums, int target) {
        // return solve(nums, 0, target, 0);
        int totalsum = 0;
        for(int num : nums){
            totalsum += num;
        }

        if (Math.abs(target) > totalsum || (totalsum + target) % 2 != 0) {
            return 0;
        }

        int requiredSum = (totalsum + target) / 2;
        return solve(nums, requiredSum);
    }
}