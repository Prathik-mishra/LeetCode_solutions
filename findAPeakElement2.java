class Solution {
    public int getMaxIdxRow(int[][] mat,int n,int col){
        int maxRowIdx = 0;
        int maxEle = mat[0][col];
        for(int i=1; i<n; i++){
            if(mat[i][col] > maxEle){
                maxEle = mat[i][col];
                maxRowIdx = i;
            }
        }
        return maxRowIdx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        //using binary search on coloms to reduce tc to log m:
        int low = 0,high = m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int maxRowIdx = getMaxIdxRow(mat,n,mid);
            int left = mid-1 >= 0 ? mat[maxRowIdx][mid-1] : -1;
            int right = mid+1 <= m-1 ? mat[maxRowIdx][mid+1] : -1;
            
            if(mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right){
               return new int[]{maxRowIdx,mid}; 
            }else if(mat[maxRowIdx][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}