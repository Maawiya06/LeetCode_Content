class Solution {
    private int solve(int num){
        if(num == 0) return 0;

        if(num % 2 == 0) return 1 + solve(num/2);

        return 1 + solve(num - 1);
    }
    public int numberOfSteps(int num) {
        return solve(num);
    }
}