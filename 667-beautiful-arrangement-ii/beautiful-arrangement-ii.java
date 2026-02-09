class Solution {
    private void solve(int n, int k, int left, int right, int[] ans){
        for(int i = 0; i < n; i++){
            if(k % 2 == 0) ans[i] = left++;
            else ans[i] = right--;

            if(k > 1) k--;
        }
    }
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        solve(n, k, 1, n, ans);
        return ans;
    }
}