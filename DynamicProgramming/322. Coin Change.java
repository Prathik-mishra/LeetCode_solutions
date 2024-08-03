class Solution {
    public int coinChange(int[] coins, int amount){
        //recursion approach:
        // int n = coins.length;
        // int ans = recur(n-1,coins,amount); 
        // if(ans == (int)1e8+1){
        //     return -1;
        // }else{
        //     return ans;
        // }
        
        //memoization approach:
        int n = coins.length;
        // int[][] dp = new int[n][amount+1];
        
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        
        // int ans = memo(n-1,coins,amount,dp); 
        // if(ans == (int)1e8+1){
        //     return -1;
        // }else{
        //     return ans;
        // }   
        
        //tabulation approach:
        // return tabulation(n,coins,amount);
        
        //spaceOptimization approach:
        return spaceOpti(n-1,coins,amount);
    }
    
    public int recur(int n,int[] coins,int target){
        if(target == 0) return 0;
        
        if(n == 0){
            if(target % coins[0] == 0){
                return target/coins[0];
            }else{
                return (int)1e8+1;
            }
        }
        
        int notTake = recur(n-1,coins,target);
        int Take = (int)1e8+1;
        if(coins[n] <= target){
            Take = 1 + recur(n,coins,target-coins[n]);
        }
        
        return Math.min(Take,notTake);
    }
    
    public int memo(int n,int[] coins,int target,int[][] dp){
        if(target == 0) return 0;
        
        if(n == 0){
            if(target % coins[0] == 0){
                return target/coins[0];
            }else{
                return (int)1e8+1;
            }
        }
        
        if(dp[n][target] != -1) return dp[n][target];
        
        int notTake = memo(n-1,coins,target,dp);
        int Take = (int)1e8+1;
        if(coins[n] <= target){
            Take = 1 + memo(n,coins,target-coins[n],dp);
        }
        
        return dp[n][target] = Math.min(Take,notTake);
    }
    
    public int tabulation(int n,int[] coins,int target){
        int[][] dp = new int[n][target+1];
        
        for(int i=0; i<=target; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] = (int)1e9;
            }
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<=target; j++){
                int notTake = dp[i-1][j];
                int Take = (int)1e9;
                if(coins[i] <= j){
                    Take = 1 + dp[i][j-coins[i]];
                }
                
                dp[i][j] = Math.min(Take,notTake);
            }
        }
        
        if(dp[n-1][target] == (int)1e9){
            return -1;
        }else{
            return dp[n-1][target];
        }
    }
    
    public int spaceOpti(int n,int[] coins,int target){
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];

        for(int i=0; i<=target; i++){
            if(i % coins[0] == 0){
                prev[i] = i/coins[0];
            }else{
                prev[i] = (int)1e9;
            }
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<=target; j++){
                int notTake = prev[j];
                int Take = (int)1e9;
                if(coins[i] <= j){
                    Take = 1 + curr[j-coins[i]];
                }
                
                curr[j] = Math.min(Take,notTake);
            }
            prev = curr;
        }
        
        if(prev[target] == (int)1e9){
            return -1;
        }else{
            return prev[target];
        }
    }
}
