class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1]; 

       
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;

        
        for (int i = 0; i < n + 1; i++) {
            int left = i + 1, right = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] - prefix[i] >= target) {
                    minLen = Math.min(minLen, mid - i);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
