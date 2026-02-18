class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n >> 1;
        int x = n ^ a;

        return (x & (x + 1)) == 0;
    }
}