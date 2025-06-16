class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];
        int m = nums1.length, n = nums2.length;

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] part1 = maxSubsequence(nums1, i);
            int[] part2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(part1, part2);
            if (greater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }
        return best;
    }

    // Get max subsequence of length k
    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1, toRemove = nums.length - k;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && toRemove > 0) {
                top--;
                toRemove--;
            }
            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                toRemove--;
            }
        }
        return stack;
    }

    // Merge two arrays to get lexicographically max result
    private int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, idx = 0;
        while (i < nums1.length || j < nums2.length) {
            if (greater(nums1, i, nums2, j)) {
                merged[idx++] = nums1[i++];
            } else {
                merged[idx++] = nums2[j++];
            }
        }
        return merged;
    }

    // Compare which array is greater starting from index i and j
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
