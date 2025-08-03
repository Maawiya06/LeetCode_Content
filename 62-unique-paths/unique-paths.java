class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        
        // C(m+n-2, m-1) = (m+n-2)! / ((m-1)! * (n-1)!)
        for (int i = 1; i <= m - 1; i++) {
            res = res * (n - 1 + i) / i;
        }
        
        return (int) res;
    }
}
