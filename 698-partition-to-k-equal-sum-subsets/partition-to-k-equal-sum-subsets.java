class Solution {
    private boolean recursion(int[] nums, int index, int currSum, int target, int k, boolean[] used) {
        if (k == 1) {
            return true;
        }
        if (currSum == target) {
            return recursion(nums, 0, 0, target, k - 1, used);
        }

        for (int i = index; i < nums.length; i++) {
            if (used[i] || currSum + nums[i] > target) continue;

            used[i] = true;
            if (recursion(nums, i + 1, currSum + nums[i], target, k, used)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;

        // sort in descending order
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }

        boolean[] used = new boolean[n];
        return recursion(nums, 0, 0, target, k, used);
    }
}
