class Solution {
    // generate all subset sums for a half of the array
    void solve(int[] nums, int index, int end, int sum, List<Integer> result) {
        if (index == end) {
            result.add(sum);
            return;
        }
        
        solve(nums, index + 1, end, sum, result);
        
        solve(nums, index + 1, end, sum + nums[index], result);
    }

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;

        // split array into two halves
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        solve(nums, 0, n / 2, 0, left);
        solve(nums, n / 2, n, 0, right);

        Collections.sort(right);

        int ans = Integer.MAX_VALUE;

        // for each left sum, find closest right sum
        for (int x : left) {
            int target = goal - x;
            int pos = Collections.binarySearch(right, target);

            if (pos >= 0) {
                return 0; 
            } else {
                pos = -(pos + 1);
                if (pos < right.size()) {
                    ans = Math.min(ans, Math.abs(x + right.get(pos) - goal));
                }
                if (pos > 0) {
                    ans = Math.min(ans, Math.abs(x + right.get(pos - 1) - goal));
                }
            }
        }
        return ans;
    }
}
