class Solution {
    //recursion: 
    public int recur(int[] nums,int i){
        if(i >= nums.length) return 0;
        
        int include = nums[i] + recur(nums,i+2);
        int exclude = recur(nums,i+1);
        
        return Math.max(include,exclude);
    }
    
    //Memoisation: 
     public int memo(int[] nums,int i,int[] dp){
        if(i >= nums.length) return 0;
        
        if(dp[i] != -1) return dp[i];
         
        int include = nums[i] + memo(nums,i+2,dp);
        int exclude = memo(nums,i+1,dp);
        
        return dp[i] = Math.max(include,exclude);
     }
    
    //tabulation: 
     public int tabulation(int[] nums,int[] dp){
        for(int i = nums.length-1;i>=0;i--){
         
        int include = nums[i] + (i+2 >= nums.length ? 0 : dp[i+2]);//memo(nums,i+2,dp);
        int exclude = (i+1 >= nums.length ? 0 : dp[i+1]);//memo(nums,i+1,dp);
        
        dp[i] = Math.max(include,exclude);
        }
        return dp[0];
     }
    
    public int rob(int[] nums) {
        // return recur(nums,0);
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp,-1);
        // return memo(nums,0,dp);
        // return tabulation(nums,dp);
        
        
        //space optimization:
        int prev = nums[0];
        int prev2 = 0;
        int n = nums.length;
        
        for(int i=1; i<n; i++){
            //1way to write if condition is handled at first:
            //int include = nums[i] + prev2;
            //2nd way to write:
            int include = nums[i] + ((i-2 >= 0) ? prev2 : 0);
            
            int exclude = prev;
            int curr = Math.max(include,exclude);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}