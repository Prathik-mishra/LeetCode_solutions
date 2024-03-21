class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //recursion approach:
        // return recur(0,0,triangle);
        
        //memoization approach:
        int n = triangle.size();
        // int[][] dp = new int[n][n];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(0,0,triangle,dp);
        
        //tabulation approach:
        //return tabulation(n,triangle);
        
        //space optimization approach:
        return spaceOpti(triangle);
    }
    
    public int recur(int i,int j,List<List<Integer>> triangle){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        
        int down = triangle.get(i).get(j) + recur(i+1,j,triangle);
        int downRight = triangle.get(i).get(j) + recur(i+1,j+1,triangle);
        
        return Math.min(down,downRight);
    }
    
    public int memo(int i,int j,List<List<Integer>> triangle,int[][] dp){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int down = triangle.get(i).get(j) + memo(i+1,j,triangle,dp);
        int downRight = triangle.get(i).get(j) + memo(i+1,j+1,triangle,dp);
        
        return dp[i][j] = Math.min(down,downRight);
    }
    
    public int tabulation(int size,List<List<Integer>> triangle){
        int n = size;
        int[][] dp = new int[n][n];
        
        //fill the base cases:
        for(int i=0; i<n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int downRight = triangle.get(i).get(j) + dp[i+1][j+1];
                
                dp[i][j] = Math.min(down,downRight);
            }
        }
        return dp[0][0];
    }
    
    public int spaceOpti(List<List<Integer>> triangle){
        int n = triangle.size();
        int[] prev = new int[n];
        
        //fill the base cases:
        for(int i=0; i<n; i++){
            prev[i] = triangle.get(n-1).get(i);
        }
        
        for(int i=n-2; i>=0; i--){
            int[] curr = new int[n];
            for(int j=i; j>=0; j--){
                int down = triangle.get(i).get(j) + prev[j];
                int downRight = triangle.get(i).get(j) + prev[j+1];
                
                curr[j] = Math.min(down,downRight);
            }
            prev = curr;
        }
        return prev[0];
    }
}