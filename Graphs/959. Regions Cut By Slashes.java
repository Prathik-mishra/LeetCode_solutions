class Solution {
    public int regionsBySlashes(String[] grid) {
        //first we need to create a new magnified grid of 3*3 for each cell: 
        int n = grid.length;

        int[][] maginfiedGrid = buildMagnifiedGrid(grid); 
        //now the area 1 represents water and 0 represents land so count the lands (we can use flood fill algo here)
         

        return floodFillAlgo(maginfiedGrid);   
    }

    private boolean possible(int x,int y,int n,int m,int[][] grid,boolean[][] visited){
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] == true || grid[x][y] == 1){
            return false;
        }
        return true;
    }

    private void bfs(int i, int j, int[][] grid, boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new Pair(i,j));

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int x = p.xCord;
            int y = p.yCord;

            for(int a=0; a<4; a++){
                int newX = x + dx[a];
                int newY = y + dy[a];

                if(possible(newX,newY,n,m,grid,visited)){
                    queue.add(new Pair(newX,newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private int floodFillAlgo(int[][] grid){
        // 1 - water and 0 is land:
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == false && grid[i][j] == 0){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }

        return count;
    }

    private int[][] buildMagnifiedGrid(String[] grid){
        int n = grid.length;
        int[][] resultant = new int[n*3][n*3];
        int x = 0, y = 0;

        for(int i=0; i<n; i++){
            String str = grid[i];
            for(int j=0; j<str.length(); j++){
                char ch = str.charAt(j);
                int baseRow = i * 3;
                int baseCol = j * 3;
                if(ch == '/'){
                    resultant[baseRow][baseCol + 2] = 1;
                    resultant[baseRow + 1][baseCol + 1] = 1;
                    resultant[baseRow + 2][baseCol] = 1;
                }else if(ch == ' '){
                    continue;
                }else{
                    resultant[baseRow][baseCol] = 1;
                    resultant[baseRow + 1][baseCol + 1] = 1;
                    resultant[baseRow + 2][baseCol + 2] = 1;
                }
            }
        }
        return resultant;
    }
}

class Pair{
    int xCord;
    int yCord;
    public Pair(int x, int y){
        this.xCord = x;
        this.yCord = y;
    }
}
