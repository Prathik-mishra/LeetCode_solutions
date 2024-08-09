class Solution {
    public int findNumberOfLIS(int[] nums) {
        int size = nums.length;
        int max = 1;

        int[] dp = new int[size];
        int[] count = new int[size];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);

        for(int i=0; i<size; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    //inherit 
                    count[i] = count[j];
                }else if(nums[i] > nums[j] && 1 + dp[j] == dp[i]){
                    //add the same counts: 
                    count[i] += count[j];
                }
            }
            max = Math.max(max,dp[i]);
        }

        int cnt = 0;
        for(int i=0; i<size; i++){
            if(dp[i] == max) cnt += count[i];
        }
        return cnt;
    }
}
