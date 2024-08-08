class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int top = 0;
        int bottom = n-1;
        int right = n-1;
        
        int pathCount = 1;
        int[][] result = new int[n][n];
        
        if(n == 0){
            return result;
        }
        
        while(top<=bottom && left<=right){
            //this is for travilling in left to right direction: 
            for(int i = left ; i <= right ; i++){
                result[top][i] = pathCount++;
            }
            top++;
            //this is for travelling in top to bottom direction in right most side of the matrix: 
            for(int i = top ; i <= bottom ; i++){
                result[i][right] = pathCount++;
            }
            right--;
            //this is for moving in right to left direction in bottom most row of the matrix:
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                result[bottom][i] = pathCount++;
            }
            bottom--; 
            }
           
            //this is for moving in bottom to top direction in the left most side of the matrix:
            if(left <= right){
               for(int i = bottom ; i >= top ; i--){
                result[i][left] = pathCount++;
            }
            left++;  
            }
           
        }
        return result;
    }
}
