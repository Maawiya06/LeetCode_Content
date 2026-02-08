class Solution {
    int count = 0;
    private void solve(int index, int n, int[] ans){
        if(index > n){
            count++;
            return;
        }

        for(int i = 1; i <= n; i++){
            if(ans[i] == 0 && (index % i == 0 || i % index == 0)){
                ans[i] = 1;
                solve(index + 1, n, ans);
                ans[i] = 0;
            }
        }
    }
    public int countArrangement(int n) {
        if(n == 0) return 0;
        int[] ans = new int[n + 1];
        solve(1, n, ans);
        return count;
    }
}