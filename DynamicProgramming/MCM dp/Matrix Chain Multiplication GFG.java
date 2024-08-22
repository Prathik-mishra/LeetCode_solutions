class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        // return recur(1,N-1,arr);
        
        //memoization: 
        // int[][] dp = new int[N][N];
        // for(int i=0; i<N; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        
        // return memo(1,N-1,arr,dp);
        
        return tabulation(N,arr);
    }
    
    private static int recur(int i,int j,int[] arr){
        if(i == j) return 0; //to multiply a single matrix n*m or i*j there is no cost 
        
        int best = Integer.MAX_VALUE;
        for(int cut = i; cut <= j-1; cut++){
            int steps = ((arr[i-1] * arr[cut] * arr[j]) + recur(i,cut,arr) + recur(cut+1,j,arr));
            best = Math.min(steps,best);
        }
        
        return best;
    }
    
    private static int memo(int i,int j,int[] arr,int[][] dp){
        if(i == j) return 0; //to multiply a single matrix n*m or i*j there is no cost 
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int best = Integer.MAX_VALUE;
        for(int cut = i; cut <= j-1; cut++){
            int steps = ((arr[i-1] * arr[cut] * arr[j]) + memo(i,cut,arr,dp) + memo(cut+1,j,arr,dp));
            best = Math.min(steps,best);
        }
        
        return dp[i][j] = best;
    }
    
    private static int tabulation(int N, int[] arr){
        int[][] dp = new int[N][N];
        
        for(int i=N-1; i>=1; i--){
            for(int j=1; j<N; j++){
                if(i >= j){
                    dp[i][j] = 0;
                    continue;
                }
                
                int best = Integer.MAX_VALUE;
                for(int cut = i; cut <= j-1; cut++){
                    int steps = ((arr[i-1] * arr[cut] * arr[j]) + memo(i,cut,arr,dp) + memo(cut+1,j,arr,dp));
                    best = Math.min(steps,best);
                }
                
                dp[i][j] = best;
            }
        }
        
        return dp[1][N-1];
    }
}
