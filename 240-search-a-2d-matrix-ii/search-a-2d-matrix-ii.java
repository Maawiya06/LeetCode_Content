class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[0].length; j++){
        //         if(matrix[i][j] == target){
        //             return true;
        //         }
        //     }
        // }

        // return false;

        int r = 0;
        int c = matrix[0].length - 1;

        while(r < matrix.length && c >= 0){
            int current = matrix[r][c];

            if(current == target){
                return true;
            }
            else if(target < current){
                c--;
            }
            else{
                r++;
            }
        }

        return false;
    }
}