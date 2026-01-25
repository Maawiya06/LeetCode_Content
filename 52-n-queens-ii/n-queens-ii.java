class Solution {
    private boolean isPresent(int n, char[][] QueensPresent, int row, int col){
        for(int i = 0; i < n; i++){
            if(QueensPresent[i][col] == 'Q') return false;
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(QueensPresent[i][j] == 'Q') return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(QueensPresent[i][j] == 'Q') return false;
        }
        return true;
    }

    private int solve(int n, char[][] QueensPresent, int row){
        if(row == n) return 1;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(isPresent(n, QueensPresent, row, i)){
                QueensPresent[row][i] = 'Q';
                count += solve(n, QueensPresent, row + 1);
                QueensPresent[row][i] = '.';
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        char[][] QueensPresent = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(QueensPresent[i], '.');
        }
        return solve(n, QueensPresent, 0);
    }
}