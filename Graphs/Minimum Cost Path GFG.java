class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.dist,y.dist));
        int[][] dist = new int[n][n];
        
        pq.add(new Pair(0,0,grid[0][0]));
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int x = p.xCord;
            int y = p.yCord;
            int dis = p.dist;
            
            if(x == n-1 && y == n-1){
                return dis;
            }
            
            for(int i=0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if(isPossible(newX,newY,n) && grid[newX][newY] + dis < dist[newX][newY]){
                    dist[newX][newY] = grid[newX][newY] + dis;
                    pq.add(new Pair(newX,newY,dis+grid[newX][newY]));
                }
            }
        }
        
        return dist[n-1][n-1];
    }
    
    private boolean isPossible(int x, int y, int n){
        if(x < 0 || x >= n || y < 0 || y >= n){
            return false;
        }
        return true;
    }
}

class Pair{
    int xCord;
    int yCord;
    int dist;
    public Pair(int x, int y,int dist){
        this.xCord = x;
        this.yCord = y;
        this.dist = dist;
    }
}
