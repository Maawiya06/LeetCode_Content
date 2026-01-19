class Solution {
    void solve(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] present){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(present[i]) continue;
            if(i > 0 && nums[i - 1] == nums[i] && !present[i - 1]) continue;
            present[i] = true;
            temp.add(nums[i]);
            solve(nums, result, temp, present);
            temp.remove(temp.size() - 1);
            present[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] present = new boolean[nums.length];
        solve(nums, result, temp, present);
        return result;
    }
}