class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // return recur(n-1, amount, coins);

        // int[][] dp = new int[coins.length][amount+1];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(n-1, amount, coins, dp);

        return tabulation(amount, coins);
    }

    private int tabulation(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<=amount; j++){
                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                } 

                if(i == 0){
                    if(j % coins[0] == 0) dp[i][j] = 1;
                    else dp[i][j] = 0;
                    continue;
                }

                int take = 0;
                if(j >= coins[i]){
                    take = dp[i][j-coins[i]]; //memo(i,j-coins[i],coins,dp);
                } 
                int notTake = dp[i-1][j]; // memo(i-1,j,coins,dp);

                dp[i][j] = take + notTake;
            }
        }

        return dp[n-1][amount];
    }

    private int memo(int i, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 1;

        if(i == 0){
            if(amount % coins[0] == 0) return 1;
            return 0;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

       int take = 0;
       if(amount >= coins[i]){
            take = memo(i,amount-coins[i],coins,dp);
       } 
       int notTake = memo(i-1,amount,coins,dp);

       return dp[i][amount] = take + notTake;
    }

    private int recur(int i, int amount, int[] coins){
        if(amount == 0) return 1;

        if(i == 0){
            if(amount % coins[0] == 0) return 1;
            return 0;
        }

       int take = 0;
       if(amount >= coins[i]){
            take = recur(i,amount-coins[i],coins);
       } 
       int notTake = recur(i-1,amount,coins);

       return take + notTake;
    }
}
