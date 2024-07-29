class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
        // return recur(N-1,-1,arr);
        // int[][] dp = new int[N][4];
        // for(int i=0; i<N; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(N-1,3,arr,dp);
        return tabulation(arr);
    }
    private int tabulation(int[][] arr){
        int n = arr.length;
        int[][] dp = new int[n][4];
        for(int i=0; i<n; i++){
            for(int j=0; j<=3; j++){
                if(i == 0){
                    int maxVal = Integer.MIN_VALUE;
                    for(int x=0; x<3; x++){
                        if(x != j){
                            maxVal = Math.max(maxVal,arr[0][x]);
                        }
                    }
                    dp[i][j] =  maxVal;
                    continue;
                }
                
                int maxPoints = Integer.MIN_VALUE;
                for(int x=0; x<3; x++){
                    int points = Integer.MIN_VALUE;
                    if(x != j){
                        points = arr[i][x] + dp[i-1][x]; 
                    }
                    maxPoints = Math.max(maxPoints,points);
                }
                
                dp[i][j] = maxPoints;
            }
        }
        return dp[n-1][3];
    }
    private int memo(int i,int j,int[][] arr,int[][] dp){
        if(i == 0){
            int maxVal = Integer.MIN_VALUE;
            for(int x=0; x<3; x++){
                if(x != j){
                    maxVal = Math.max(maxVal,arr[0][x]);
                }
            }
            return maxVal;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int maxPoints = Integer.MIN_VALUE;
        for(int x=0; x<3; x++){
            int points = Integer.MIN_VALUE;
            if(x != j){
                points = arr[i][x] + Math.max(points,memo(i-1,x,arr,dp));
            }
            maxPoints = Math.max(maxPoints,points);
        }
        
        return dp[i][j] = maxPoints;
    }
    
    private int recur(int i,int j,int[][] arr){
        if(i == 0){
            int maxVal = Integer.MIN_VALUE;
            for(int x=0; x<3; x++){
                if(x != j){
                    maxVal = Math.max(maxVal,arr[0][x]);
                }
            }
            return maxVal;
        }
        
        int maxPoints = Integer.MIN_VALUE;
        for(int x=0; x<3; x++){
            int points = Integer.MIN_VALUE;
            if(x != j){
                points = arr[i][x] + Math.max(points,recur(i-1,x,arr));
            }
            maxPoints = Math.max(maxPoints,points);
        }
        
        return maxPoints;
    }
}
