class Solution {
    private int solve(int[][] grid){
        int n = grid.length;
        int[] zeros = new int[n];

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = n - 1; j >= 0 && grid[i][j] == 0; j--){
                count++;
            }
            zeros[i] = count;
        }

            // now for swap
            int swap = 0;
            for(int i = 0; i < n; i++){
                int req = n - i - 1;
                int j = i;
                while(j < n && zeros[j] < req) j++;

                if(j == n) return -1;
                while(j > i){
                    int temp = zeros[j];
                    zeros[j] = zeros[j - 1];
                    zeros[j - 1] = temp;
                    j--;
                    swap++;
                }
            }
            return swap;
    }
    public int minSwaps(int[][] grid) {
        return solve(grid);
    }
}