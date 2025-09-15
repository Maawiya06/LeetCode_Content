class Solution {
    boolean solve(int[] nums, int index, int sum, int target, int[][] dp){
        // base case
        if(index >= nums.length){
            return false;
        }
        if(sum > target){
            return false;
        }
        if(sum == target){
            return true;
        }
        if(dp[index][sum] != -1){
            return dp[index][sum] == 1;
        }
        // recursive solution
        boolean include = solve(nums, index + 1, sum + nums[index], target, dp);
        boolean exclude = solve(nums, index + 1, sum, target, dp);

        dp[index][sum] = (include || exclude) ? 1 : 0;
        return dp[index][sum] == 1;
    }

    public boolean canPartition(int[] nums) {
        int index = 0;
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }

        // check if odd
        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum / 2;
        int currSum = 0;

        int[][] dp = new int[nums.length + 1][target + 1];
        for(int j = 0; j <= nums.length; j++){
            Arrays.fill(dp[j], -1);
        }
        boolean ans = solve(nums, index, currSum, target, dp);
        return ans;
    }
}
