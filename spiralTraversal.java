class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int top = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        List<Integer> spiral = new ArrayList();
        
        if(matrix.length == 0){
            return spiral;
        }
        
        while(top<=bottom && left<=right){
            //this is for travilling in left to right direction: 
            for(int i = left ; i <= right ; i++){
                spiral.add(matrix[top][i]);
            }
            top++;
            //this is for travelling in top to bottom direction in right most side of the matrix: 
            for(int i = top ; i <= bottom ; i++){
                spiral.add(matrix[i][right]);
            }
            right--;
            //this is for moving in right to left direction in bottom most row of the matrix:
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                spiral.add(matrix[bottom][i]);
            }
            bottom--; 
            }
           
            //this is for moving in bottom to top direction in the left most side of the matrix:
            if(left <= right){
               for(int i = bottom ; i >= top ; i--){
                spiral.add(matrix[i][left]);
            }
            left++;  
            }
           
        }
        return spiral;
    }
}
