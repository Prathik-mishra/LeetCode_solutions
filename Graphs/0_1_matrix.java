class Solution {
    class Pair{
        int first;
        int second;
        int third;
        public Pair(int f,int s,int t){
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] dist = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        //initalize the distance array: 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i,j,0));
                    visit[i][j] = true;
                }else{
                    visit[i][j] = false; 
                }
            }
        }
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            int r = p.first;
            int c = p.second;
            int num = p.third;
            dist[r][c] = num;
            for(int i=0; i<4; i++){
                int row = r + delRow[i];
                int col = c + delCol[i];
                if(row>=0 && row<n && col>=0 && col<m && !visit[row][col]){
                    visit[row][col] = true;
                    q.offer(new Pair(row,col,num+1));
                }
            }
        }
        return dist;
    }
}
