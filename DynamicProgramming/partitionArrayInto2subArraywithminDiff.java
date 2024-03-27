class Solution {
    public int minimumDifference(int[] nums) {
        //figureout the range the partitions can be done 
        // we can see the partion can be done in the range of 0 to total sum of the array
        
        int n = nums.length;
        int Tsum = 0;
        for(int i : nums){
            Tsum += i;
        }
        
        int target = Tsum;
        
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
        
        int minPartitionSum = Integer.MAX_VALUE;
        for(int i=0; i<=Tsum; i++){
            if(dp[n-1][i] == true){
                int sum1 = i;
                int sum2 = (Tsum - i);
                minPartitionSum = Math.min(minPartitionSum,Math.abs(sum1-sum2));
            }
        }
        return minPartitionSum;
    }
}
