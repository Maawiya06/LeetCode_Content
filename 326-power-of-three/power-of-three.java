class Solution {
    public boolean isPowerOfThree(int n) {
        
        // int s = 1;
        // int e = n;
        // if(n <= 0) return false;
        // while(s <= e){
        //     long mid = s + (e - s)/2;
        //     long cube = mid * mid * mid;
        //     if(cube == n){
        //         return true;
        //     }
        //     else if(cube < n){
        //         s = (int)mid + 1;
        //     }
        //     else{
        //         e = (int)mid - 1;
        //     }
        // }

        // return false;

        if (n <= 0) return false;

        long val = 1;
        while (val < n) {
            val *= 3;
        }
        return val == n;
    }
}