class Solution {
    void solve(int k, int n, int start, List<List<Integer>> result, List<Integer> temp){
        if(k == 0 && n == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        if(k == 0 || n < 0) return;
        
        for(int i = start; i <= 9; i++){
            if(i > n) break;
            temp.add(i);
            solve(k - 1, n - i, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(k, n, 1, result, temp);
        return result;
    }
}