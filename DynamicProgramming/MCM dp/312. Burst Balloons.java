class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> numLis = new ArrayList<>();
        numLis.add(1);
        for(int ele : nums) numLis.add(ele);
        numLis.add(1);
        int n = numLis.size();

        // return func(1,n-2,numLis);
        // int[][] dp = new int[n][n];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return func(1,n-2,numLis,dp);

        return tabulation(numLis,n);
    }

    private int func(int i, int j, ArrayList<Integer> numLis){
        if(i > j) return 0;

        int best = Integer.MIN_VALUE;
        for(int bust = i; bust <= j; bust++){
            int cost = numLis.get(i-1) * numLis.get(bust) * numLis.get(j+1) 
            + func(i,bust-1,numLis) + func(bust+1,j,numLis);
            best = Math.max(best,cost);
        }

        return best;
    }

    private int func(int i, int j, ArrayList<Integer> numLis, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int best = Integer.MIN_VALUE;
        for(int bust = i; bust <= j; bust++){
            int cost = numLis.get(i-1) * numLis.get(bust) * numLis.get(j+1) 
            + func(i,bust-1,numLis,dp) + func(bust+1,j,numLis,dp);
            best = Math.max(best,cost);
        }

        return dp[i][j] = best;
    }

    private int tabulation(ArrayList<Integer> numLis, int n){
        int[][] dp = new int[n][n];

        for(int i=n-2; i>=1; i--){
            for(int j=1; j<=n-2; j++){
                if(i > j) continue;

                int best = Integer.MIN_VALUE;
                for(int bust = i; bust <= j; bust++){
                    int cost = numLis.get(i-1) * numLis.get(bust) * numLis.get(j+1) 
                    + dp[i][bust-1] + dp[bust+1][j];
                    best = Math.max(best,cost);
                }

                dp[i][j] = best;
            }
        }
        return dp[1][n-2];
    }
}
