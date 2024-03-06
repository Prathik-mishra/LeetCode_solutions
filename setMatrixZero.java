class Solution {
    public void setZeroes(int[][] matrix) {
        // for marking the col -> matrix[0][..];
        // for marking the row -> matrix[..][0];
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int col0 = 1;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    //for row marking: 
                    matrix[i][0] = 0;
                    //for col marking: 
                    if(j == 0){
                        col0 = 0;
                    }else{
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int j = 0 ; j < m ; j++){
                matrix[0][j] = 0;
            }
        }
        
        if(col0 == 0){
            for(int i = 0 ; i < n ; i++){
                matrix[i][0] = 0;
            }
        }
    }
}