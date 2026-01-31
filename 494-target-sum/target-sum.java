class Solution {
    private int solve(int[] nums, int i, int target, int sum){
        if(i >= nums.length) return sum == target ? 1 : 0;

        int subs = solve(nums, i + 1, target, sum - nums[i]);
        int add = solve(nums, i + 1, target, sum + nums[i]);
        return subs + add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target, 0);
    }
}