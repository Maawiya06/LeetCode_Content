class Solution {
    private boolean check(int[] simNums, int curr, int startDir) {
        int n = simNums.length;
        int dir = startDir;

        while (curr >= 0 && curr < n) {
            if (simNums[curr] == 0) {
                curr += dir;
            } else {
                simNums[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int val : simNums) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int validCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int[] numsCopyLeft = Arrays.copyOf(nums, n);
                if (check(numsCopyLeft, i, -1)) {
                    validCount++;
                }
                int[] numsCopyRight = Arrays.copyOf(nums, n);
                if (check(numsCopyRight, i, 1)) {
                    validCount++;
                }
            }
        }
        
        return validCount;
    }
}