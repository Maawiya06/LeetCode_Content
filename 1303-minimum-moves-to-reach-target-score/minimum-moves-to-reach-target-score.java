class Solution {
    // 1> greddy apprach
    private int solve(int target, int maxDoubles){
        int steps = 0;

        while(target > 1 && maxDoubles > 0){
            if(target % 2 == 0){
                target = target / 2;
                maxDoubles--;
            }
            else{
                target = target - 1;
            }
            steps++;
        }
        if(target > 1){
            steps = steps + (target - 1);
        }
        return steps;
    }

    // 2> backward resursion
    // private int solve(int target, int maxDoubles){
    //     //base case
    //     if(target == 1) return 0;

    //     // if no double left 
    //     if(maxDoubles == 0) return target - 1;

    //     // if even
    //     if(target % 2 == 0) return 1 + solve(target / 2, maxDoubles - 1);

    //     // if odd
    //     return 1 + solve(target - 1, maxDoubles);
    // }
    public int minMoves(int target, int maxDoubles) {
        return solve(target, maxDoubles);
    }
}