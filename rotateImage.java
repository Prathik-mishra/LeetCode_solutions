class Solution {
    public void rotate(int[][] matrix) {
        
        // do the transpose of the matrix:
        int n = matrix.length;
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i+1 ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // reverse each rows in the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        
        
    }
}