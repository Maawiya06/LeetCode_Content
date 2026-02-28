class Solution {
    public int concatenatedBinary(int n) {
        // optimised 
        long ans = 0;
        int bit = 0;
        int mod = 1_000_000_007;

        for(int i = 1; i <= n; i++){
            if((i & (i - 1)) == 0){
                bit++;
            }
            ans = ((ans << bit) % mod + i) % mod;
        }
        return (int)ans;
        // String str = "";
        // int mod = 1000000007;
        // for(int i = 0; i <= n; i++){
        //     String binary = Integer.toBinaryString(i);
        //     str = str + binary;
        //     long result = Long.parseLong(str, 2);
        //     result = result % mod;
        //     str = Long.toBinaryString(result);
        // }
        // return (int)Long.parseLong(str, 2);
    }
}