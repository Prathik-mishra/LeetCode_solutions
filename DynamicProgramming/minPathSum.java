class Solution {
    public int recur(int[][] grid,int i,int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        
        int right = recur(grid,i,j+1);
        int down = recur(grid,i+1,j);
        
        return Math.min(right,down)+grid[i][j];
    }
    
     public int memo(int[][] grid,int i,int j,int[][] dp){
        if(i == grid.length || j == grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
         
        if(dp[i][j] != -1) return dp[i][j];
        
        int right = memo(grid,i,j+1,dp);
        int down = memo(grid,i+1,j,dp);
        
        return dp[i][j] = Math.min(right,down)+grid[i][j];
    }
     public int tabulation(int[][] grid,int[][] dp){
       
        int n = grid.length;
        int m = grid[0].length;
        for(int i = n-1 ; i >= 0 ; i--){
          for(int j = m-1 ; j >= 0 ; j--){
             if(i == grid.length-1 && j == grid[0].length-1){
                dp[i][j] =  grid[i][j];
                 continue;
             }
         
             int right = j+1 < m ? dp[i][j+1] : Integer.MAX_VALUE; //memo(grid,i,j+1,dp);
             int down =  i+1 < n ? dp[i+1][j] : Integer.MAX_VALUE;//memo(grid,i+1,j,dp);
        
             dp[i][j] = Math.min(right,down)+grid[i][j];
          }
        }
        return dp[0][0];
    }
    
    public int spaceOpti(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        int[] prev = new int[m];
        for(int i=0; i<n; i++){
            int[] curr = new int[m];
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }else{
                    int left = grid[i][j];
                    if(j > 0) left += curr[j-1];
                    else left = Integer.MAX_VALUE;
                    
                    int up = grid[i][j];
                    if(i > 0) up += prev[j];
                    else up = Integer.MAX_VALUE;
                    
                    curr[j] = Math.min(left,up);
                }     
            }
            prev = curr;
        }
        return prev[m-1];
    }
    public int minPathSum(int[][] grid) {

        // int[][] dp = new int[grid.length][grid[0].length];
        // for(int i = 0 ; i < grid.length ; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return recur(grid,0,0);
       // return memo(grid,0,0,dp);
        // return tabulation(grid,dp);
        
        return spaceOpti(grid);
    }
}
