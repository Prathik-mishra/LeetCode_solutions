class Solution {
    public int numDistinct(String s, String t) {
        // int n = s.length(), m = t.length();
        // int[][] dp = new int[n+1][m+1];
        // for(int i=0; i<=n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return recur(s,t,n,m);
        // return memo(s,t,n,m,dp);
        // return tabulation(s,t);
        return spaceOpti(s,t);
    }

    private int tabulation(String s, String t){
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                }else if(i == 0) continue;

                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    private int spaceOpti(String s, String t){
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];

        for(int i=0; i<=n; i++){
            int[] curr = new int[m+1];
            for(int j=0; j<=m; j++){
                if(j == 0){
                    curr[j] = 1;
                    continue;
                }else if(i == 0) continue;

                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    private int memo(String s,String t, int i, int j,int[][] dp){
        if(j == 0 ) return 1;
        if(i == 0 ) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = memo(s,t,i-1,j-1,dp) + memo(s,t,i-1,j,dp);
        }else{
            return dp[i][j] = memo(s,t,i-1,j,dp);
        }
    }

    private int recur(String s,String t, int i, int j){
        if(j < 0 ) return 1;
        if(i < 0 ) return 0;

        if(s.charAt(i) == t.charAt(j)){
            return recur(s,t,i-1,j-1) + recur(s,t,i-1,j);
        }else{
            return recur(s,t,i-1,j);
        }
    }
}
