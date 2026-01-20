class Solution {
    boolean solve(char[][] board, String word, boolean[][] flag, int i, int j, int index){
        if(index == word.length()) return true;

        if(i < 0 || i >= board.length 
                                     || j < 0 || j >= board[0].length 
                                     || flag[i][j] || board[i][j] != word.charAt(index)) {
                                      return false;
                                     }
        
        flag[i][j] = true;

        if(
            solve(board, word, flag, i + 1, j, index + 1)||
            solve(board, word, flag, i - 1, j, index + 1)||
            solve(board, word, flag, i, j + 1, index + 1)||
            solve(board, word, flag, i, j - 1, index + 1))
            {
            return true;
            }
        

        flag[i][j] = false;
        return false;  
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] flag = new boolean[n][m];
        boolean ans = false;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    ans = solve(board, word, flag, i, j, 0);
                    if(ans) return true;
                }
            }
        }
        return false;
    }
}