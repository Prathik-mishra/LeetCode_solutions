class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
        //  return recur(W,n-1,wt,val);
        
        //memoization approach:
        // int[][] dp = new int[n][W+1];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(W,n-1,wt,val,dp);
        
        //tabulation approach:
        //return tabulation(W,n,wt,val);
        
        return spaceOpti(W,n,wt,val);
    } 
    
    public static int spaceOpti(int w, int n , int wt[], int val[]){
         
        int[] prev = new int[w+1];
        
        for(int i=wt[0]; i<w+1; i++){
            prev[i] = val[0]; 
        }
        
        for(int i=1; i<n; i++){
            for(int j=w; j>=0; j--){
                int take = Integer.MIN_VALUE;
                if(wt[i] <= j){
                    take = val[i] + prev[j-wt[i]];
                }
                int notTake = prev[j]; 
                
                prev[j] = Math.max(take,notTake);
            }
        }
        return prev[w];
    }
    
    public static int tabulation(int w, int n , int wt[], int val[]){
        
        int[][] dp = new int[n][w+1];
        
        for(int i=wt[0]; i<w+1; i++){
            dp[0][i] = val[0]; 
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<w+1; j++){
                int take = Integer.MIN_VALUE;
                if(wt[i] <= j){
                    take = val[i] + dp[i-1][j-wt[i]];
                }
                int notTake = dp[i-1][j]; 
                
                dp[i][j] = Math.max(take,notTake);
            }
        }
        return dp[n-1][w];
    }
    
    public static int memo(int w, int n , int wt[], int val[],int[][] dp){
        if(n == 0){
            if(wt[0] <= w){
                return val[0];
            }else{
                return 0;
            }
        }
        
        if(dp[n][w] != -1) return dp[n][w];
        
        int take = Integer.MIN_VALUE;
        if(wt[n] <= w){
            take = val[n] + memo(w-wt[n],n-1,wt,val,dp);
        }
        int notTake = memo(w,n-1,wt,val,dp);
        
        return dp[n][w] = Math.max(take,notTake);
    }
    
    public static int recur(int w, int n , int wt[], int val[]){
        if(n == 0){
            if(wt[0] <= w){
                return val[0];
            }else{
                return 0;
            }
        }
        
        int take = Integer.MIN_VALUE;
        if(wt[n] <= w){
            take = val[n] + recur(w-wt[n],n-1,wt,val);
        }
        int notTake = recur(w,n-1,wt,val);
        
        return Math.max(take,notTake);
    }
}