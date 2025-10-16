class Solution {
    int solve(int start, int end){
        if(start > end) return 1;
        if(start == end) return 1;
        
        int ans = 0;
        for(int i = start; i <= end; i++){
            int left = solve(start, i - 1);
            int right = solve(i + 1, end);

            ans = ans + left * right;
        }
        return ans;
    }
    public int numTrees(int n) {
        return solve(1, n);
    }
}