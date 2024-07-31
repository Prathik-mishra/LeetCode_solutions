class Solution {
    public int sWidth;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        sWidth = shelfWidth;
        // return recur(0,books,shelfWidth,0);
        int[][] dp = new int[books.length][shelfWidth+1];
        return memo(0,books,shelfWidth,0,dp);
    }
    
    private int recur(int idx,int[][] books,int currShelfWidth, int currHeight){
        int maxHeight = Math.max(books[idx][1], currHeight);
        
        if(idx == books.length-1){
            if(books[idx][0] <= currShelfWidth) return maxHeight;
            return currHeight + books[idx][1];
        }
        
        int currShelf = Integer.MAX_VALUE;
        if(books[idx][0] <= currShelfWidth){
            currShelf = recur(idx+1,books,currShelfWidth-books[idx][0],maxHeight);
        }
            
        int newShelf = currHeight + recur(idx+1,books,sWidth-books[idx][0],books[idx][1]);
            
        return Math.min(currShelf,newShelf);
    }
    
    private int memo(int idx,int[][] books,int currShelfWidth, int currHeight, int[][] dp){
        int maxHeight = Math.max(books[idx][1], currHeight);
        
        if(idx == books.length-1){
            if(books[idx][0] <= currShelfWidth) return maxHeight;
            return currHeight + books[idx][1];
        }
        
        if(dp[idx][currShelfWidth] != 0) return dp[idx][currShelfWidth];
        
        int currShelf = Integer.MAX_VALUE;
        if(books[idx][0] <= currShelfWidth){
            currShelf = memo(idx+1,books,currShelfWidth-books[idx][0],maxHeight,dp);
        }
            
        int newShelf = currHeight + memo(idx+1,books,sWidth-books[idx][0],books[idx][1],dp);
            
        return dp[idx][currShelfWidth] = Math.min(currShelf,newShelf);
    }
}
