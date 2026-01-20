class Solution {
    void solve(int n, int k, List<List<Integer>> result, List<Integer> temp, int index){
        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i <= n; i++){
            temp.add(i);
            solve(n, k, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(n, k, result, temp, 1);
        return result;
    }
}