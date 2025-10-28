import java.util.Arrays;

class Solution {
    private boolean check(int[] simNums, int curr, int startDir) {
        int n = simNums.length;
        int dir = startDir;
        int totalSum = 0;
        for(int x : simNums) totalSum += x;
        int maxSteps = simNums.length * totalSum + simNums.length * simNums.length + 1000;
        int steps = 0;
        while (curr >= 0 && curr < n && steps < maxSteps) {
            steps++;
            
            if (simNums[curr] == 0) {
                
                curr += dir;
            } else {
                
                simNums[curr]--;
                
                dir = -dir;
                
                curr += dir;
            }
        }
        if (steps == maxSteps) return false;
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