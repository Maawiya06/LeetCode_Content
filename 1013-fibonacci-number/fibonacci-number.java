class Solution {
    public int solveusingMem(int n, ArrayList<Integer> dp){
        //base case
        if(n == 0 || n == 1){
            return n;
        }
        
        // ak br solve kr lya dobara solve nhi krna h 
        if(dp.get(n) != -1){
            return dp.get(n);
        }

        dp.set(n, solveusingMem(n - 1, dp) + solveusingMem(n - 2, dp));
        return dp.get(n);
    }
    public int fib(int n) {
        
        //base case
        // procesing
        // recursive relation
        // if(n == 0 || n == 1){
        //     return n;
        // }

        // int ans = fib(n - 1) + fib(n - 2);
        // return ans;

        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            dp.add(-1);
        }
        int ans = solveusingMem(n, dp);
        return ans;
    }
}