class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] countN = digitCount(n);
        
        for (int i = 0; i < 31; i++) { 
            int power = 1 << i;
            if (sameCount(countN, digitCount(power))) {
                return true;
            }
        }
        return false;
    }

    private int[] digitCount(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }

    private boolean sameCount(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
