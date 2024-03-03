class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        // Iterate through all possible combinations of values for cells belonging to the Y
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i == j) continue;
                // Calculate operations needed for each combination
                int res = countOperations(grid, i, j);
                ans = Math.min(ans, res);
            }
        }
        return ans;   
    }
    
    public int countOperations(int[][] grid,int a,int b){
        int n = grid.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if((i <= (n/2) && i == j)   || (i+j == n-1 && j >= (n/2)) || (j == (n/2) && i > (n/2))){
                    if(grid[i][j] != a){
                        ans++;
                    }
                }else{
                    if(grid[i][j] != b){
                        ans++;
                    }
                }
            }    
        }
        return ans;
    }
}