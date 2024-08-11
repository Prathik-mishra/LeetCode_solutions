class Solution {
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int noOfIsland = getNoIslands(grid);

        if(noOfIsland == 0 || noOfIsland > 1){
            return 0;
        }

        //if we are reaching this statement then we have to check wheather it will take 1 or 2 days to make island disconnected
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0; //making land to water
                    noOfIsland = getNoIslands(grid);
                    if(noOfIsland > 1 || noOfIsland == 0){
                        return 1;
                    }
                    grid[i][j] = 1; //making water to land reverse
                }
            }
        }

        return 2;
    }

    private int getNoIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    floodFillAlgo(i,j,grid,visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void floodFillAlgo(int i,int j,int[][] grid,boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int x = p.xCord;
            int y = p.yCord;

            for(int a=0; a<4; a++){
                int newX = x + dx[a];
                int newY = y + dy[a];
                if(possible(newX,newY,grid,visited)){
                    queue.add(new Pair(newX,newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean possible(int i,int j,int[][] grid,boolean[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true){
            return false;
        }
        return true;
    }
}

class Pair{
    int xCord;
    int yCord;
    public Pair(int x,int y){
        this.xCord = x;
        this.yCord = y;
    }
}
