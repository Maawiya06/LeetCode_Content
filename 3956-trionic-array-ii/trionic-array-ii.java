class Solution {
    long NEG = -100000000000000L;
    Long[][] dp;

    long f(int index, int status, int n, int[] nums) {
        if (index == n) {
            return status == 3 ? 0 : NEG;
        }

        if (dp[index][status] != null) return dp[index][status];

        long take = NEG;
        long notTake = NEG;

        if (status == 0) {
            notTake = f(index + 1, 0, n, nums);
        }

        if (status == 3) {
            take = nums[index];
        }

        if (index + 1 < n) {
            if (status == 0 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
            } 
            else if (status == 1) {
                if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
                } else if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
                }
            } 
            else if (status == 2) {
                if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
                } else if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
                }
            } 
            else if (status == 3 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
            }
        }

        return dp[index][status] = Math.max(take, notTake);
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        dp = new Long[n][4];
        return f(0, 0, n, nums);
    }
}