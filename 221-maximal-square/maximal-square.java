class Solution {
    int maxi = 0; 

    int solve(char[][] matrix, int i, int j, int row, int col, int[][] dp) {
        // base case
        if (i >= row || j >= col) {
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // explore all ways
        int right = solve(matrix, i, j + 1, row, col, dp);
        int down = solve(matrix, i + 1, j, row, col, dp);
        int diagonal = solve(matrix, i + 1, j + 1, row, col, dp);

        if (matrix[i][j] == '1') {
            dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
            maxi = Math.max(maxi, dp[i][j]);  
            return dp[i][j];
        } else {
            dp[i][j] = 0;
            return 0;
        }
    }

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], -1);
        }
        solve(matrix, 0, 0, row, col, dp);
        return maxi * maxi;
    }
}
