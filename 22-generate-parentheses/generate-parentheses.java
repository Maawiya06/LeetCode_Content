class Solution {
    void solve(int n, int start, int end, String curr, List<String> result){
        // base case
        if(curr.length() == 2 * n){
            result.add(curr);
            return;
        }

        if(start < n){
            solve(n, start + 1, end, curr + "(", result);
        }
        if(end < start){
            solve(n, start, end + 1, curr + ")", result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, "", ans);
        return ans;
    }
}