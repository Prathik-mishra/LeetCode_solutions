class Solution {
    private static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    private static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0){
            return false;
        }

        int n = grid.length;
        int startVal = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int x = p.xCord;
            int y = p.yCord;

            if(grid[x][y] == ((n*n)-1)){
                return true;
            }

            for(int i=0; i<8; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == grid[x][y]+1){
                    queue.add(new Pair(newX,newY));
                }
            }
        }

        return false;
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
