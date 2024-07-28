class Solution {
    private static ArrayList<Integer> perfectSqLis;
    public int numSquares(int n) {
        perfectSqLis = generatePerfectSq(n);
        // return recur(perfectSqLis.size()-1,n);
        // int[][] dp = new int[perfectSqLis.size()][n+1];
        // for(int i=0; i<perfectSqLis.size(); i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(perfectSqLis.size()-1,n,dp);
        return tab(n);
    }
    private int tab(int n){
        int[][] dp = new int[perfectSqLis.size()][n+1];
        
        for(int i=0; i<perfectSqLis.size(); i++){
            for(int j=0; j<=n; j++){
                if(j == 0){
                    continue;
                }

                int pick = (int)1e9;
                if(j - perfectSqLis.get(i) >= 0){
                    pick = 1 + dp[i][j-perfectSqLis.get(i)]; 
                }
                int notPick = (i-1 < 0) ? (int)1e9 : dp[i-1][j];

                dp[i][j] = Math.min(pick,notPick);
            }
        }
        
        return dp[perfectSqLis.size()-1][n];
    }
    
    private int memo(int i,int n,int[][] dp){
        if(n == 0){
            return 0;
        }
        
        if(i < 0){
            return (int)1e9;
        }
        
        if(dp[i][n] != -1) return dp[i][n];
        
        int pick = (int)1e9;
        if(n - perfectSqLis.get(i) >= 0){
            pick = 1 + memo(i,n-perfectSqLis.get(i),dp);
        }
        int notPick = memo(i-1,n,dp);
        
        return dp[i][n] = Math.min(pick,notPick);
    }
    
    private int recur(int i,int n){
        if(n == 0){
            return 0;
        }
        
        if(i < 0){
            return (int)1e9;
        }
        
        int pick = (int)1e9;
        if(n - perfectSqLis.get(i) >= 0){
            pick = 1 + recur(i,n-perfectSqLis.get(i));
        }
        int notPick = recur(i-1,n);
        
        return Math.min(pick,notPick);
    }
        
    private ArrayList<Integer> generatePerfectSq(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            list.add(i*i);
        }
        
        return list;
    }
}
