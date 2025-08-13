class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n <= 0) return false;

        long val = 1;
        while(val < n){
            val *= 4;
        }
        return val == n;
    }
}