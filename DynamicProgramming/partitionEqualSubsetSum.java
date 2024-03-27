class Solution {
    public boolean canPartition(int[] nums) {
        int Tsum = 0;
        for(int i : nums){
            Tsum += i;
        }
        
        //if the total sum of the array is odd then we cannot divide the array into to two equal sum parts
        if(Tsum % 2 == 1){
            return false;
        } 
        
        int sum = Tsum/2;
        int n = nums.length;
        
        //the intution says that if we manage to get Tsum/2 target in the array then it is sure that we can partition the array so perform the recursion to find the answer and optimise it further
          
        //recursive approach:
        // return recur(nums,n-1,sum);
        
        //memoization approach:
        // int[][] dp = new int[n][sum+1];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        //  if(memo(nums,n-1,sum,dp) == 1){
        //      return true;
        //  }else{
        //      return false;
        //  }
        
        //tabulation approach:
        return tabulation(nums,n,sum);
    }
    
    public boolean recur(int[] nums,int n,int target){
        if(target == 0){
            return true;
        }
        
        if(n == 0){
            if(nums[0] == target){
                return true;
            }else{
                return false ;
            }
        }
        
        boolean notTake = recur(nums,n-1,target);
        boolean Take = false;
        if(nums[n] <= target){
            Take = recur(nums,n-1,target-nums[n]);
        }
        
        return (Take || notTake);
    }
    
    public int memo(int[] nums,int n,int target,int[][] dp){
        if(target == 0){
            return 1;
        }
        
        if(n == 0){
            if(nums[0] == target){
                return 1;
            }else{
                return 0;
            }
        }
        
        if(dp[n][target] != -1) return dp[n][target];
        
        int notTake = memo(nums,n-1,target,dp);
        int Take = 0;
        if(nums[n] <= target){
            Take = memo(nums,n-1,target-nums[n],dp);
        }
        
        if(Take == 1 || notTake == 1){
            return dp[n][target] = 1;
        }else{
            return dp[n][target] = 0;
        }
    }
    
    public boolean tabulation(int[] nums,int n,int target){
        
        boolean[][] dp = new boolean[n][target+1];
        
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        
        if(target >= nums[0]) dp[0][nums[0]] = true;
        
        for(int i=1; i<n; i++){
            for(int tar=1; tar<=target; tar++){
                boolean notTake = dp[i-1][tar];
                boolean Take = false;
                if(nums[i] <= tar){
                    Take = dp[i-1][tar-nums[i]];
                }
            dp[i][tar] = (Take || notTake); 
            }
        }
        
        return dp[n-1][target];
    }
    
    public boolean spaceOpti(int[] nums,int n,int target){
        
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if(target >= nums[0]) prev[nums[0]] = true;
        
        for(int i=1; i<n; i++){
            boolean[] curr = new boolean[target+1];
            for(int tar=1; tar<=target; tar++){
                boolean notTake = prev[tar];
                boolean Take = false;
                if(nums[i] <= tar){
                    Take = prev[tar-nums[i]];
                }
            curr[tar] = (Take || notTake); 
            }
            prev = curr;
        }
        
        return prev[target];
    }
}
