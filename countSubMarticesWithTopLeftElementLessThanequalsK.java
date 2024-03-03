class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prefixMatrix = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0){
                    prefixMatrix[i][j] = grid[i][j];
                }else if(i == 0){
                    prefixMatrix[i][j] = grid[i][j] + prefixMatrix[i][j-1];
                }else if(j == 0){
                    prefixMatrix[i][j] = grid[i][j] + prefixMatrix[i-1][j];
                }else{
                    prefixMatrix[i][j] = prefixMatrix[i][j-1] + prefixMatrix[i-1][j] - prefixMatrix[i-1][j-1] + grid[i][j];
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(prefixMatrix[i][j] <= k){
                    count++;
                }
            }
        }
        return count;
    }
}