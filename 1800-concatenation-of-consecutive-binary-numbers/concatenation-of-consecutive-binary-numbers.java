class Solution {
    public int concatenatedBinary(int n) {
        String str = "";
        int mod = 1000000007;
        for(int i = 0; i <= n; i++){
            String binary = Integer.toBinaryString(i);
            str = str + binary;
            long result = Long.parseLong(str, 2);
            result = result % mod;
            str = Long.toBinaryString(result);
        }
        return (int)Long.parseLong(str, 2);
    }
}