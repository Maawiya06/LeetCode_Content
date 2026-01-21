class Solution {
    public int reverse(int x) {
        int rev = 0;
        boolean isnegative = false;
        if(x <= Integer.MIN_VALUE){
            return 0;
        }
        if(x < 0){
            isnegative = true;
            x = -x;
        }
        while(x > 0){
            if(rev > Integer.MAX_VALUE/10){
                return 0;
            }
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }
        return isnegative ? -rev : rev;
    }
}