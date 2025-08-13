class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n <= 0) return false;

        long val = 1;
        while(val < n){
            val *= 2;
        }

        return val == n;
    }
}