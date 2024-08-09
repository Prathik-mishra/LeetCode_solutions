class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int[] dp1 = new int[n];
        
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max,dp1[j]);
                }
            }
            dp1[i] = max+1;
        }
        
        int[] dp2 = new int[n];
        for(int i=n-1; i>=0; i--){
            int max = 0;
            for(int j=n-1; j>i; j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max,dp2[j]);
                }
            }
            dp2[i] = max+1;
        }
        
        int lbs = 0;
        for(int i=0; i<n; i++){
            lbs = Math.max(lbs,dp1[i]+dp2[i]-1);
        }
        
        return lbs;
    }
}
