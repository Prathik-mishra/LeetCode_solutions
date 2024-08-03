class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        // return recur(N-1,W,val,wt);
        // int[][] dp = new int[N][W+1];
        // for(int i=0; i<N; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(N-1,W,val,wt,dp);
        return tabulation(N,W,val,wt);
    }
    
    private static int tabulation(int n, int W, int val[], int wt[]){
        int[][] dp = new int[n][W+1];
        
        for(int i=0; i<n; i++){
            for(int w=0; w<=W; w++){
                if(i == 0){
                    dp[i][w] = w/wt[i] * val[i];
                    continue;
                }
                
                int take = Integer.MIN_VALUE;
                if(w >= wt[i]){
                    take = val[i] + dp[i][w-wt[i]]; // memo(n,w-wt[n],val,wt,dp);
                }
                int notTake = dp[i-1][w];  // memo(n-1,w,val,wt,dp);
                
                dp[i][w] = Math.max(take,notTake);
            }
        }
        
        return dp[n-1][W];
    }
    
    private static int memo(int n, int w, int val[], int wt[], int[][] dp){
        if(w == 0){
            return 0;
        }
        
        if(n == 0){
            return w/wt[n] * val[n];
        }
        
        if(dp[n][w] != -1) return dp[n][w];
        
        int take = Integer.MIN_VALUE;
        if(w >= wt[n]){
            take = val[n] + memo(n,w-wt[n],val,wt,dp);
        }
        int notTake = memo(n-1,w,val,wt,dp);
        
        return dp[n][w] = Math.max(take,notTake);
    }
    
    private static int recur(int n, int w, int val[], int wt[]){
        if(w == 0){
            return 0;
        }
        
        if(n == 0){
            return w/wt[n] * val[n];
        }
        
        int take = Integer.MIN_VALUE;
        if(w >= wt[n]){
            take = val[n] + recur(n,w-wt[n],val,wt);
        }
        int notTake = recur(n-1,w,val,wt);
        
        return Math.max(take,notTake);
    }
}
