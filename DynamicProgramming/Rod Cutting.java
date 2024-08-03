class Solution{
    public int cutRod(int price[], int n) {
        //code here
        // return recur(n-1,n,price);
        // int[][] dp = new int[n][n+1];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(n-1,n,price,dp);
        return tabulation(price,n);
    }
    
    private int tabulation(int price[], int n){
        int[][] dp = new int[n][n+1];
        
        for(int i=0; i<n; i++){
            for(int len=0; len<=n; len++){
                if(i == 0){
                    dp[i][len] = price[0] * len;
                    continue;
                }
                
                int take = Integer.MIN_VALUE;
                int rodLen = i+1;
                if(rodLen <= len){
                    take = price[i] + dp[i][len-rodLen]; //memo(i,len-rodLen,price,dp);
                }
                
                int notTake = dp[i-1][len]; // memo(i-1,len,price,dp);
                
                dp[i][len] = Math.max(take,notTake);
            }
        }
        
        return dp[n-1][n];
    }
    
    private int memo(int i, int len, int[] price, int[][] dp){
        if(len == 0) return 0;
        
        if(i == 0){
            return price[0] * len;
        }
        
        if(dp[i][len] != -1) return dp[i][len];
        
        int take = Integer.MIN_VALUE;
        int rodLen = i+1;
        if(rodLen <= len){
            take = price[i] + memo(i,len-rodLen,price,dp);
        }
        
        int notTake = memo(i-1,len,price,dp);
        
        return dp[i][len] = Math.max(take,notTake);
    }
    
    private int recur(int i, int len, int[] price){
        if(len == 0) return 0;
        
        if(i == 0){
            return price[0] * len;
        }
        
        int take = Integer.MIN_VALUE;
        int rodLen = i+1;
        if(rodLen <= len){
            take = price[i] + recur(i,len-rodLen,price);
        }
        
        int notTake = recur(i-1,len,price);
        
        return Math.max(take,notTake);
    }
}
