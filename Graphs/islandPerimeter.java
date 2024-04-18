class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0,n = grid.length,m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    if(i-1 < 0){
                        count++;
                    }else{
                        if(grid[i-1][j] == 0){
                            count++;
                        }
                    }
                    
                    if(i+1 >= n){
                        count++;
                    }else{
                        if(grid[i+1][j] == 0){
                            count++;
                        }
                    }
                    
                    if(j-1 < 0){
                       count++; 
                    }else{
                        if(grid[i][j-1] == 0){
                            count++;
                        }
                    }
                    
                    if(j+1 >= m){
                       count++; 
                    }else{
                        if(grid[i][j+1] == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
