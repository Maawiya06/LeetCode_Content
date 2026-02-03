class Solution {

    private boolean solve(long a, long b, int i, String num, int count){
        if(i == num.length()) return count >= 3;

        long sum = a + b;
        long curr = 0;

        for(int index = i; index < num.length(); index++){

            if (num.charAt(i) == '0' && index > i) break;
            
            curr = curr * 10 + (num.charAt(index) - '0');

            if(curr == sum){
                if(solve(b, sum, index + 1, num, count + 1))
                    return true;
            }
            if(curr > sum) break;
        }
        return false;
    }

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        long first = 0;
        for(int i = 0; i < n - 1; i++){
            first = first * 10 + (num.charAt(i) - '0');

            if(i > 0 && num.charAt(0) == '0') break;

            long second = 0;
            for(int j = i + 1; j < n; j++){
                second = second * 10 + (num.charAt(j) - '0');
                // check leading zero for 2nd number
                if (j > i + 1 && num.charAt(i + 1) == '0') break;

                if(solve(first, second, j + 1, num, 2)) return true;
            }
        }
        return false;
    }
}
