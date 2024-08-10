class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        for(int[] arr : cuboids){
            Arrays.sort(arr); 
        }

        Arrays.sort(cuboids, (a,b) -> {
            if(a[0] != b[0]){
                return -Integer.compare(a[0],b[0]);
            }else if(a[1] != b[1]){
                return -Integer.compare(a[1],b[1]);
            }
            return -Integer.compare(a[2],b[2]);
        });

        int maxHeight = 0;
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = cuboids[i][2];
            int maxi = 0;
            for(int j=0; j<i; j++){
                if(cuboids[i][0] <= cuboids[j][0] && cuboids[i][1] <= cuboids[j][1] && cuboids[i][2] <= cuboids[j][2]){
                    maxi = Math.max(maxi,dp[j]);
                }
            }
            dp[i] = Math.max(dp[i],dp[i]+maxi);
            maxHeight = Math.max(maxHeight,dp[i]);
        } 

        return maxHeight;
    }
}
