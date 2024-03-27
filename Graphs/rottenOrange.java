class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
        
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[n][m];
        
        int noOfFreshOranges = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else if(grid[i][j] == 1){
                    noOfFreshOranges++;
                }
            }
        }
        
        int minTime = 0;
        int count = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                
                Pair p = queue.remove();
                int row = p.row;
                int col = p.col;
                int time = p.time;
                
                minTime = Math.max(minTime,time);

                //the below algo is a modified bfs algo:
                /*
                //this diagram gives us a idea of how we can make fresh orange rotten moving in alternate directions:  
                                        (row-1,col)
                                            |
                                            |
                    (row,col-1)  <--  Curr(row,col)  --> (row,col+1)        
                                            |
                                            |
                                        (row+1,col)
                                            
                */
                
                int dx[] = {-1,0,1,0};
                int dy[] = {0,1,0,-1};
                
                for(int x=0; x<4; x++){
                    
                    int newRow = row + dx[x];
                    int newCol = col + dy[x];
                    
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] != 2 && grid[newRow][newCol] == 1){
                        
                        queue.add(new Pair(newRow,newCol,time+1));
                        vis[newRow][newCol] = 2;
                        count++;
                    }
                }
            }
        }
        
        if(count == noOfFreshOranges){
            return minTime;
        }
        return -1;
    }
}

class Pair{
    int row;
    int col;
    int time;
    public Pair(int x,int y,int z){
        this.row = x;
        this.col = y;
        this.time = z;
    }
}