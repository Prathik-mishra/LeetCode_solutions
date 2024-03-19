class Solution {
    public int recur(int[][] arr,int i,int j){
        int n = arr.length;
        int m = arr[0].length;
        if(i == n || j == m) return 0;
        if(i == n-1 && j == m-1) return 1;
        
        int right = recur(arr,i,j+1);
        int down = recur(arr,i+1,j);
        
        return right+down;
    }
    
    //memoization approach: 
     public int memo(int[][] arr,int i,int j,int[][] dp){
        int n = arr.length;
        int m = arr[0].length;
        if(i == n || j == m) return 0;
        if(i == n-1 && j == m-1) return 1;
         
        if(dp[i][j] != 0) return dp[i][j];
        
        int right = memo(arr,i,j+1,dp);
        int down = memo(arr,i+1,j,dp);
        
        return dp[i][j] = right+down;
    }
    
     //tabulation approach: 
     public int tabulation(int[][] arr,int[][] dp){
        int n = arr.length;
        int m = arr[0].length;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i == n-1 && j == m-1){
                    dp[i][j] = 1;
                    continue;
                }
                int right = j+1<m ? dp[i][j+1] : 0; //memo(arr,i,j+1,dp);
                int down =  i+1<n ? dp[i+1][j] : 0; //memo(arr,i+1,j,dp);
        
                dp[i][j] = right+down;
            }
        }
        return dp[0][0];
    }
    public int uniquePaths(int m, int n) {
        //int[][] board = new int[m][n];
        // return recur(board,0,0);
        //int[][] dp = new int[m][n];
        // return memo(board,0,0,dp);
        //return tabulation(board,dp);
        
        int[] prev = new int[n];
        for(int i=0; i<m; i++){
            int[] curr = new int[n];
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) {
                    curr[j] = 1;
                }else{
                    if(j == 0){
                        curr[j] = 1;                        
                    }else{
                        curr[j] = prev[j] + curr[j-1];
                    }
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}