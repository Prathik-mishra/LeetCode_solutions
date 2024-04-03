class Solution {
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((x,y) -> Integer.compare((x.absDiff),(y.absDiff)));
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] diff = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(diff[i],Integer.MAX_VALUE);
        }
        diff[0][0] = 0;
        
        int[] delX = {-1,0,1,0};
        int[] delY = {0,1,0,-1};
        queue.add(new Pair(0,0,0));
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            int dif = pair.absDiff;
            int x = pair.xcod;
            int y = pair.ycod;
            
            if(x == n-1 && y == m-1){
                return dif;
            }
            
            for(int i=0; i<delX.length; i++){
                int newX = x + delX[i];
                int newY = y + delY[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    
                    int newEffort = Math.max(Math.abs(grid[x][y] - grid[newX][newY]),dif);  
                    
                    if(newEffort < diff[newX][newY]){
                        diff[newX][newY] = newEffort;
                        queue.add(new Pair(newEffort,newX,newY));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    int absDiff;
    int xcod;
    int ycod;
    public Pair(int x,int y,int z){
        this.absDiff = x;
        this.xcod = y;
        this.ycod = z;
    }
}
