class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        //recursive approach:
        // return recur(N-1,arr,sum);
        
        //memoization approach:
        // int dp[][] = new int[N+1][sum+1];
        // for(int i=0; i<N+1; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        
        // return (memo(N-1,arr,sum,dp) == 1) ? true : false; 
        
        return tabulation(N,arr,sum);
    }
    
    public static boolean recur(int n,int[] arr,int sum){
        if(sum == 0){
            return true;
        }
        
        if(n == 0){
            return (sum == arr[n]);
        }
        
        //take:
        boolean take = false;
        if(arr[n] <= sum){
            take = recur(n-1,arr,sum-arr[n]);
        }
        
        //not-take:
        boolean notTake = recur(n-1,arr,sum); 
        
        
        return (take || notTake);
    }
    
    public static int memo(int n,int[] arr,int sum,int[][] dp){
        if(sum == 0){
            return 1;
        }
        
        if(n == 0){
            return (sum == arr[n]) ? 1 : 0;
        }
        
        if(dp[n][sum] != -1) return dp[n][sum];
        
        //take:
        int take = 0;
        if(arr[n] <= sum){
            take = memo(n-1,arr,sum-arr[n],dp);
        }
        
        //not-take:
        int notTake = memo(n-1,arr,sum,dp); 
        
        
        return (dp[n][sum] = (take == 1 || notTake == 1) ? 1 : 0);
    }
    
    public static boolean tabulation(int n, int[] arr,int sum){
        
        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i=0; i<n; i++){
            dp[i][0] = true; 
        }
        
        if(sum >= arr[0]) dp[0][arr[0]] = true;
        
        for(int i=1; i<n; i++){
            for(int target=1; target<=sum; target++){
                boolean take = false;
                if(arr[i] <= target){
                    take = dp[i-1][target-arr[i]]; 
                }
                boolean notTake = dp[i-1][target];
                
                dp[i][target] = (take || notTake);
            }
        }
        return dp[n-1][sum];
    }
    
    public static boolean spaceOpti(int n, int[] arr,int sum){
        
        boolean[] prev = new boolean[sum+1];
        
        prev[0] = true;
        
        if(sum >= arr[0]) prev[arr[0]] = true;
        
        for(int i=1; i<n; i++){
            boolean[] curr = new boolean[sum+1];
            for(int target=1; target<=sum; target++){
                boolean take = false;
                if(arr[i] <= target){
                    take = prev[target-arr[i]]; 
                }
                boolean notTake = prev[target];
                
                curr[target] = (take || notTake);
            }
            prev = curr;
        }
        return prev[sum];
    }
}
