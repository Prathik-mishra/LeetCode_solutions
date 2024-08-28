class Solution {
    public boolean validPartition(int[] nums) {
        // return func(nums,0);

        // Boolean dp[] = new Boolean[nums.length+1];
        // return func(nums,0,dp);

        return tabulation(nums);
    }

    private boolean func(int[] nums, int i){
        if(i == nums.length){
            return true;
        }

        boolean valid = false;
        if(i+2 <= nums.length && nums[i] == nums[i+1]){
            valid = valid || func(nums,i+2);
        }
        if(i+3 <= nums.length){
            if((nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) || 
               (nums[i] == nums[i+1]-1 && nums[i+1] == nums[i+2]-1)){
                valid = valid || func(nums,i+3);
            }
        }

        return valid;
    }

    private boolean func(int[] nums, int i, Boolean[] dp){
        if(i == nums.length){
            return true;
        }

        if(dp[i] != null) return dp[i];

        boolean valid = false;
        if(i+2 <= nums.length && nums[i] == nums[i+1]){
            valid = valid || func(nums,i+2,dp);
        }
        if(i+3 <= nums.length){
            if((nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) || 
               (nums[i] == nums[i+1]-1 && nums[i+1] == nums[i+2]-1)){
                valid = valid || func(nums,i+3,dp);
            }
        }

        return dp[i] = valid;
    }

    private boolean tabulation(int[] nums){
        int n = nums.length; 
        boolean dp[] = new boolean[n+1];

        for(int i=n; i>=0; i--){
            if(i == n){
                dp[i] = true;
                continue;
            }

            boolean valid = false;
            if(i+2 <= nums.length && nums[i] == nums[i+1]){
                valid = valid || dp[i+2]; 
            }
            if(i+3 <= nums.length){
                if((nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) || 
                (nums[i] == nums[i+1]-1 && nums[i+1] == nums[i+2]-1)){
                    valid = valid || dp[i+3]; 
                }
            }

            dp[i] = valid;
        }

        return dp[0];
    }
}
