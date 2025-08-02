class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;

        int oneCount = Integer.MIN_VALUE;
        int rowNo = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count > oneCount) {
                oneCount = count;
                rowNo = i;
            }
        }

        return new int[]{rowNo, oneCount};
    }
}
