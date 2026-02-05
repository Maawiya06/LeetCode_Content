class Solution {
    private void solve(int[] nums, List<List<Integer>> result, List<Integer> ans, int index) {
        if (ans.size() >= 2) {
            result.add(new ArrayList<>(ans));
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (used.contains(nums[i])) continue;

            if (ans.size() == 0 || nums[i] >= ans.get(ans.size() - 1)) {
                used.add(nums[i]);

                ans.add(nums[i]);
                solve(nums, result, ans, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(nums, result, ans, 0);
        return result;
    }
}
