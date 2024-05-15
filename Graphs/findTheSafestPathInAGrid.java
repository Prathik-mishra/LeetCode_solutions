class Solution {
    
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        Queue<Pair> queue = new LinkedList<>();
        int[][] mat = new int[n][n]; 
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid.get(i).get(j) == 1){
                    //adding the pair for multisource traversal of the graph:
                    queue.add(new Pair(i,j));
                    mat[i][j] = 0;
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        // calculation for all the cells using bfs:
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair p = queue.remove();
                for(int i=0; i<4; i++){
                    int newX = p.xCod + dx[i];
                    int newY = p.yCod + dy[i];
                    if(isValidCell(newX,newY,n) && mat[newX][newY] == -1){
                        mat[newX][newY] = mat[p.xCod][p.yCod] + 1;
                        queue.add(new Pair(newX,newY));
                    }
                }
            }
        }
        
        int low = 0;
        int high = getHigh(mat,n);
        int ans = -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(isValidPath(mat,mid,n)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    private boolean isValidPath(int[][] mat,int mid,int n){
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        
        if (mat[0][0] < mid || mat[n - 1][n - 1] < mid) {
            return false;
        }
        
        queue.add(new Pair(0,0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair p = queue.remove();
                int x = p.xCod;
                int y = p.yCod;
                if(x == n-1 && y == n-1){
                    return true;
                }
                for(int i=0; i<4; i++){
                    int newX = p.xCod + dx[i];
                    int newY = p.yCod + dy[i];
                    if(isValidCell(newX,newY,n) && !visit[newX][newY] && mat[newX][newY] >= mid){
                        visit[newX][newY] = true;
                        queue.add(new Pair(newX,newY));
                    }
                }
            }
        }
        return false;
    }
    
    private boolean isValidCell(int x,int y,int n){
        return x>=0 && x<n && y>=0 && y<n; 
    }
    
    private int getHigh(int[][] mat,int n){
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans,mat[i][j]);            
            }
        }
        return ans;
    }
}

class Pair{
    int xCod;
    int yCod;
    public Pair(int x,int y){
        this.xCod = x;
        this.yCod = y;
    }
}
