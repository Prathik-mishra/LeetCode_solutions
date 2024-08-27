class Solution {
    public int minCost(int n, int[] cuts) {
        // Arrays.sort(cuts);
        // ArrayList<Integer> cutsLis = new ArrayList<>();
        // cutsLis.add(0);
        // for(int element : cuts) cutsLis.add(element);
        // cutsLis.add(n);

        // // return recur(1,cuts.length,cutsLis);

        // int[][] dp = new int[cutsLis.size()+1][cutsLis.size()+1];
        // for(int i=0; i<cutsLis.size()+1; i++) Arrays.fill(dp[i],-1);
        // return memo(1,cuts.length,cutsLis,dp);

        return tabulation(n,cuts);
    }

    private int tabulation(int n, int[] cuts){
        Arrays.sort(cuts);
        ArrayList<Integer> cutsLis = new ArrayList<>();
        cutsLis.add(0);
        for(int element : cuts) cutsLis.add(element);
        cutsLis.add(n);

        int[][] dp = new int[cutsLis.size()+1][cutsLis.size()+1];

        for(int i=cuts.length; i>=1; i--){
            for(int j=1; j<=cuts.length; j++){
                if(i>j) continue;

                int cost = cutsLis.get(j+1) - cutsLis.get(i-1);
                int best = Integer.MAX_VALUE;

                for(int cut=i; cut<=j; cut++){
                    int leftPart = dp[i][cut-1]; 
                    int rightPart = dp[cut+1][j];
                    int currBest = leftPart + cost + rightPart;
                    best = Math.min(best,currBest);
                }

                dp[i][j] = best;
            }
        }
        return dp[1][cuts.length];
    }

    private int memo(int i, int j,ArrayList<Integer> cutsLis,int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int cost = cutsLis.get(j+1) - cutsLis.get(i-1);
        int best = Integer.MAX_VALUE;

        for(int cut=i; cut<=j; cut++){
            int leftPart = memo(i,cut-1,cutsLis,dp);
            int rightPart = memo(cut+1,j,cutsLis,dp);
            int currBest = leftPart + cost + rightPart;
            best = Math.min(best,currBest);
        }

        return dp[i][j] = best;
    }

    private int recur(int i, int j,ArrayList<Integer> cutsLis){
        if(i>j) return 0;

        int cost = cutsLis.get(j+1) - cutsLis.get(i-1);
        int best = Integer.MAX_VALUE;

        for(int cut=i; cut<=j; cut++){
            int leftPart = recur(i,cut-1,cutsLis);
            int rightPart = recur(cut+1,j,cutsLis);
            int currBest = leftPart + cost + rightPart;
            best = Math.min(best,currBest);
        }

        return best;
    }


}
