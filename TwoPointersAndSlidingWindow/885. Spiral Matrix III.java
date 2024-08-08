class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int pathCount = 1;
        int rEnd = rStart+1, cEnd = cStart+1;

        int[][] mat = new int[rows*cols][2];

        while(pathCount <= (rows*cols)){
            
            //path 1:
            for(int i=cStart; i<cEnd; i++){
                if(pathCount <= (rows*cols) && rStart >= 0 && rStart < rows && i >= 0 && i < cols){
                    mat[pathCount-1][0] = rStart;
                    mat[pathCount-1][1] = i;
                    pathCount++;
                }
            }
            cStart--;

            //path 2:
            for(int i=rStart; i<rEnd; i++){
                if(pathCount <= (rows*cols) && cEnd >= 0 && cEnd < cols && i >= 0 && i < rows){
                    mat[pathCount-1][0] = i;
                    mat[pathCount-1][1] = cEnd;
                    pathCount++;
                }
            }
            rStart--;

            //path 3:
            for(int i=cEnd; i>cStart; i--){
                if(pathCount <= (rows*cols) && rEnd >= 0 && rEnd < rows && i >= 0 && i < cols){
                    mat[pathCount-1][0] = rEnd;
                    mat[pathCount-1][1] = i;
                    pathCount++;
                }
            }
            cEnd++;

            //path 4:
            for(int i=rEnd; i>rStart; i--){
                if(pathCount <= (rows*cols) && cStart >= 0 && cStart < cols && i >= 0 && i < rows){
                    mat[pathCount-1][0] = i;
                    mat[pathCount-1][1] = cStart;
                    pathCount++;
                }
            }
            rEnd++;
        }

        return mat;
    }
}
