class Solution {
    // public int memoRec(int n,int[] dp){
        //Base case: 
//         if(n == 0 || n == 1) return 1;
        
//         if(dp[n] != 0) return dp[n];
//         //calling recursion for step n-1 and step n-2: 
//         int stepM1 = memoRec(n-1,dp);
//         int stepM2 = memoRec(n-2,dp);
        
//         dp[n] = stepM1 + stepM2;
        
//         return stepM1 + stepM2;
//     }
        
        //by Tabulation: 
//     public int tabulation(int n,int[] dp){
        
       
//         for(int i=0;i<=n;i++){
//             if(i == 0 || i == 1){
//                 dp[i] = 1;
//                 continue;
//             }
//              int stepM1 = dp[i-1];//memoRec(n-1,dp);
//              int stepM2 = dp[i-2];//memoRec(n-2,dp);
//              int ans = stepM1 + stepM2;
//              dp[i] = ans;
//         } 
//         return dp[n];
//     }
    
    public int spaceOpti(int n,int[] dp){
        if(n<=1){
            return 1;
        }
        int stepM1 = 1;
        int stepM2 = 1;
        for(int i=2;i<=n;i++){
            int curr = stepM1 + stepM2;
            if(i == n) return curr;
            
            stepM1 = stepM2;
            stepM2 = curr;
        }
        return 0;//dummy
    }
        
    public int climbStairs(int n) {
        //int dp[] = new int[n+1];
        // return memoRec(n,dp);
        // return tabulation(n,dp);
        return spaceOpti(n,dp);
    }
}