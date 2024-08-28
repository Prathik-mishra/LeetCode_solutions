class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        
        // return func(nums,target);
        
        // dp = new int[target+1];
        // Arrays.fill(dp,-1);
        // return func(nums,target);

        return tabulation(nums,target);
    }

    // private int func(int[] nums, int target){
    //     if(target == 0){
    //         return 1;
    //     }

    //     int totalWays = 0;
    //     for(int i=0; i<nums.length; i++){
    //         if(target-nums[i] >= 0){
    //             totalWays += func(nums,target-nums[i]);
    //         }
    //     }

    //     return totalWays;
    // }

    private int func(int[] nums, int target){
        if(target == 0){
            return 1;
        }

        if(dp[target] != -1) return dp[target];

        int totalWays = 0;
        for(int i=0; i<nums.length; i++){
            if(target-nums[i] >= 0){
                totalWays += func(nums,target-nums[i]);
            }
        }

        return dp[target] = totalWays;
    }

    private int tabulation(int[] nums, int tar){
        dp = new int[tar+1];

        for(int target=0; target<=tar; target++){
            if(target == 0){
                dp[target] = 1;
                continue;
            }

            int totalWays = 0;
            for(int i=0; i<nums.length; i++){
                if(target-nums[i] >= 0){
                    totalWays += dp[target-nums[i]]; //func(nums,target-nums[i],dp);
                }
            }

            dp[target] = totalWays;
        }
        return dp[tar];
    }
}
