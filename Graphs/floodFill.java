class Solution {
    public void dfs(int[][] image, int sr, int sc, int color,int[][] copyImage,int[] delRow,int[] delCol,int sameColr){
        copyImage[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++){
            int row = sr+delRow[i];
            int col = sc+delCol[i];
            if(row >= 0 && row < n && col >= 0 && col < m && copyImage[row][col] == sameColr && copyImage[row][col] != color){
                dfs(image,row,col,color,copyImage,delRow,delCol,sameColr);
            } 
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] copyImage = image;
        int sameColr = image[sr][sc];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        dfs(image,sr,sc,color,copyImage,delRow,delCol,sameColr);
        return copyImage;
    }
}