class Solution {
//     private int dfs(int i,int j,int[][] grid, boolean[][] visited, int walkable){
//         if(grid[i][j] == -1){
//             return 0;
//         }
        
//         if(grid[i][j] == 2){
//             //here we have consumed zeros and made it -1:
//             if(walkable == -1){
//                 return 1;
//             }
//             return 0;
//         }
        
//         int dx[] = {-1,0,1,0};
//         int dy[] = {0,1,0,-1};
//         int count = 0;
        
        
//         for(int x=0; x<4; x++){
//             int newI = i + dx[x];
//             int newJ = j + dy[x];
            
//             if(newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && visited[newI][newJ] == false){
//                 visited[newI][newJ] = true;
               
//                 count += dfs(newI,newJ,grid,visited,walkable-1);
                
//                 visited[newI][newJ] = false;
//             }       
//         }
//         return count;
//     }
    private int dfs(int i,int j,int[][] grid, boolean[][] visited, int walkable){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || visited[i][j] == true){
            return 0;
        }
        
        if(grid[i][j] == 2){
            if(walkable == -1){
                return 1;
            }
            return 0;
        }
        
        visited[i][j] = true;
        walkable--;
        
        int count = dfs(i-1,j,grid,visited,walkable) + 
            dfs(i,j+1,grid,visited,walkable) + 
            dfs(i+1,j,grid,visited,walkable) + 
            dfs(i,j-1,grid,visited,walkable);
        
        walkable++;
        visited[i][j] = false;
        
        return count;
    }
    public int uniquePathsIII(int[][] grid) {
        int countWalkable = 0;
        int n = grid.length,m = grid[0].length;
        int startSqI = -1, startSqJ = -1;
        int endSqI = -1, endSqJ = -1;
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    countWalkable++;
                }else if(grid[i][j] == 1){
                    startSqI = i;
                    startSqJ = j;
                    // visited[startSqI][startSqJ] = true; //should be used for variant of dfs method written above
                }
            }
        }
        
        
        return dfs(startSqI,startSqJ,grid,visited,countWalkable);  
    }
}
