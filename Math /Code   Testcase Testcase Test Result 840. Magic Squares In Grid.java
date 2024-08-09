class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int countMagicSqMat = 0;
        int n = grid.length, m = grid[0].length;

        for(int rStart = 0; rStart+2 < n; rStart++){
            for(int cStart = 0; cStart+2 < m; cStart++){
                countMagicSqMat += compute(rStart,cStart,grid) == true ? 1 : 0;
            }
        }

        return countMagicSqMat;
    }

    private boolean compute(int rStart, int cStart, int[][] grid){
        int row1 = 0, row2 = 0, row3 = 0;
        int col1 = 0, col2 = 0, col3 = 0;
        int leftDiag = 0, rightDiag = 0;

        int copyrStart = rStart, copycStart = cStart;
        for(int x=0; x<3; x++){
            rightDiag += grid[copyrStart++][copycStart++];
        } 

        boolean[] visit = new boolean[10];

        for(int x=0,i=rStart; i<=rStart+2; x++,i++){
            for(int y=0,j=cStart; j<=cStart+2; y++,j++){
                if(grid[i][j] == 0 || grid[i][j] > 9) return false;
                
                visit[grid[i][j]] = true;

                if(x+y == 2){
                    leftDiag += grid[i][j];
                }

                if(x == 0){
                    row1 += grid[i][j];
                }else if(x == 1){
                    row2 += grid[i][j];
                }else{
                    row3 += grid[i][j];
                }

                if(y == 0){
                    col1 += grid[i][j];
                }else if(y == 1){
                    col2 += grid[i][j];
                }else{
                    col3 += grid[i][j];
                }
            }
        }
        
        for(int i=1; i<10; i++){
            if(visit[i] == false) return false;
        }

        if(leftDiag != rightDiag || row1 != rightDiag || row2 != rightDiag || row3 != rightDiag || col1 != rightDiag || col2 != rightDiag || col3 != rightDiag){
                                    return false;
        }

        return true;
    }
}
