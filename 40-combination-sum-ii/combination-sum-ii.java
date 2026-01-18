class Solution {
    void solve(int[] candidates, int target, 
                        int index, List<Integer> temp, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(index == candidates.length || target < 0) return;

        // include
        temp.add(candidates[index]);
        solve(candidates, target - candidates[index], index + 1, temp, result);
        temp.remove(temp.size() - 1);

        // remove duplications
        int nextIndex = index + 1;
        while(nextIndex < candidates.length && candidates[nextIndex] == candidates[index]){
            nextIndex++;
        }
        // exclude
        solve(candidates, target, nextIndex, temp, result);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // List<Integer> temp = new ArrayList<>();

        solve(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
}