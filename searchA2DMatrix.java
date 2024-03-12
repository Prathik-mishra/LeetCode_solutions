class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // This method is called a STAIR CASE SEARCHING
       // - Used in Matrix (2D array)
       // - (Rows should be sorted or Both (Row and column should be sorted))
        
//         int n = matrix.length;
//         int m = matrix[0].length;
        
//         int row = 0;
//         int col = m-1;
        
//         while(row < n && col >= 0){
//             int currentElement = matrix[row][col];
//             if(currentElement == target){
//                 return true;
//             }else if(currentElement < target){
//                 // We need to increase current element (going down)
//                 row++;
//             }else{
//                 // We need to decrease current element (going left)
//                 col--;
//             }
//         }
//         return false;
        
        //optimised approach:
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0,high = ((n*m)-1);
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid+1;
            else high = mid-1;
        }
        return false;
        
        /* Intution behind for dividing and modululatig the new indices by m:
        at row 0 the elements will have index from 0 to m-1 so while divide we get 0
        at row 1 the elements will have index from m to (m*2)-1 so while divide we get 1
        at row 2 the elements will have index from m*2 to (m*3)-1 so while divide we get 2
        
        so ultimately we are getting the row number while dividing a number by the m
        
        now for colums 
        at col 0 the elements will be multiple of m so multiple % m we will get 0
        at col 1 the elements will be multiple of m+1 so multiple+1 % m we will get 1
        at col 2 the elements will be multiple of m+2 so multiple+2 % m we will get 2
        */
    }
}