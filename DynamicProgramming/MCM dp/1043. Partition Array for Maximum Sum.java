class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // return func(arr,k,0);

        // int[] dp = new int[arr.length];
        // Arrays.fill(dp,-1);
        // return func(arr,k,0,dp);

        return tabulation(arr,k,arr.length);
    }

    private int tabulation(int[] arr, int k, int n){
        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int i=n-1; i>=0; i--){

            int maxPartSum = Integer.MIN_VALUE;
            int len = 1, maxVal = Integer.MIN_VALUE;
            for(int j=i; j<Math.min(n,i+k); j++){
                maxVal = Math.max(arr[j],maxVal);
                int currPartSum = (len*maxVal) + dp[j+1];
                maxPartSum = Math.max(maxPartSum, currPartSum);
                len++;
            } 

            dp[i] = maxPartSum;
        }

        return dp[0];
    }

    private int func(int[] arr, int k, int i, int[] dp){
        if(i == arr.length){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int maxPartSum = Integer.MIN_VALUE;
        int len = 1, maxVal = Integer.MIN_VALUE;
        for(int j=i; j<Math.min(arr.length,i+k); j++){
            maxVal = Math.max(arr[j],maxVal);
            int currPartSum = (len*maxVal) + func(arr,k,j+1,dp);
            maxPartSum = Math.max(maxPartSum, currPartSum);
            len++;
        } 

        return dp[i] = maxPartSum;
    }

    private int func(int[] arr, int k, int i){
        if(i == arr.length){
            return 0;
        }

        int maxPartSum = Integer.MIN_VALUE;
        int len = 1, maxVal = Integer.MIN_VALUE;
        for(int j=i; j<Math.min(arr.length,i+k); j++){
            maxVal = Math.max(arr[j],maxVal);
            int currPartSum = (len*maxVal) + func(arr,k,j+1);
            maxPartSum = Math.max(maxPartSum, currPartSum);
            len++;
        } 

        return maxPartSum;
    }
}
