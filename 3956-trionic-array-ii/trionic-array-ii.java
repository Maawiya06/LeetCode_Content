class Solution {
    long NEG = -100000000000000L;
    Long[][] dp;

    private long solve(int index, int status, int n, int[] nums) {

        if (index == n) {
            return status == 3 ? 0 : NEG;
        }

        if (dp[index][status] != null) {
            return dp[index][status];
        }

        long take = NEG;
        long notTake = NEG;

        // option to skip only when status = 0
        if (status == 0) {
            notTake = solve(index + 1, 0, n, nums);
        }

        // once status = 3, we can always take
        if (status == 3) {
            take = nums[index];
        }

        // transition based on next element
        if (index + 1 < n) {

            if (status == 0 && nums[index + 1] > nums[index]) {
                take = Math.max(
                        take,
                        nums[index] + solve(index + 1, 1, n, nums)
                );
            }

            else if (status == 1) {
                if (nums[index + 1] > nums[index]) {
                    take = Math.max(
                            take,
                            nums[index] + solve(index + 1, 1, n, nums)
                    );
                } 
                else if (nums[index + 1] < nums[index]) {
                    take = Math.max(
                            take,
                            nums[index] + solve(index + 1, 2, n, nums)
                    );
                }
            }

            else if (status == 2) {
                if (nums[index + 1] < nums[index]) {
                    take = Math.max(
                            take,
                            nums[index] + solve(index + 1, 2, n, nums)
                    );
                } 
                else if (nums[index + 1] > nums[index]) {
                    take = Math.max(
                            take,
                            nums[index] + solve(index + 1, 3, n, nums)
                    );
                }
            }

            else if (status == 3 && nums[index + 1] > nums[index]) {
                take = Math.max(
                        take,
                        nums[index] + solve(index + 1, 3, n, nums)
                );
            }
        }

        dp[index][status] = Math.max(take, notTake);
        return dp[index][status];
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        dp = new Long[n][4];
        return solve(0, 0, n, nums);
    }
}
