class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;    //edge case 
         
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1,0,0));
        int n = grid.length;
        int[][] dist = new int[n][n];
                       
        for(int i=0; i<grid.length; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 1;                   //updating the distance matrix  
        int[] delX = {-1,-1,0,1,1,1,0,-1};
        int[] delY = {0,1,1,1,0,-1,-1,-1};
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            int distance = pair.dist;
            int xcod = pair.xcod;
            int ycod = pair.ycod;
            for(int i=0; i<delX.length; i++){
                int newX = xcod + delX[i];
                int newY = ycod + delY[i];
                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length && distance + 1 < dist[newX][newY] && grid[newX][newY] == 0){
                    dist[newX][newY] = distance + 1;
                    queue.add(new Pair(dist[newX][newY],newX,newY));
                }
            }
        }
        
        if(dist[n-1][n-1] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[n-1][n-1];
        }
    }
}
class Pair{
    int dist;
    int xcod;
    int ycod;
    public Pair(int x,int y,int z){
        this.dist = x;
        this.xcod = y;
        this.ycod = z;
    }
}
