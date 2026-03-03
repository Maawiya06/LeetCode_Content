class Solution {
    private char solve(int n, int k){
        if(n == 1) return '0';

        int len = (1 << n) - 1;
        int mid = (len + 1)/2;

        if(k == mid) return '1';
        if(k < mid){
            return solve(n - 1, k);
        }
        else{
            char right = solve(n - 1, len - k + 1);
            return right == '0' ? '1' : '0';
        }
    }
    public char findKthBit(int n, int k) {
        return solve(n, k);
    }
}