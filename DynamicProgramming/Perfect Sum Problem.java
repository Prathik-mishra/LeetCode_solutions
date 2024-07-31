class Solution{
    private static int mod = (int)1e9 + 7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	   // return recur(arr,n,sum,0);
	   int[][] dp = new int[n][sum+1];
	   for(int i=0; i<n; i++){
	       Arrays.fill(dp[i],-1);
	   }
	   return memo(arr,n,sum,0,dp);
	} 
	
	private int tabulation(int[] arr,int n,int target){
	    int[][] dp = new int[n][target+1];
	    for(int idx=arr.length-1; idx>=0; idx--){
	        for(int sum=target; sum >=0; sum--){
	            if(idx == n){
        	        if(sum == 0) dp[idx][sum] = 1;
        	        else dp[idx][sum] = 0;
        	        continue;
        	    }
        	    
        	    int left = 0,right = 0;
        	    if(sum >= arr[idx]){
        	        left = dp[idx+1][sum-arr[idx]]; 
        	    }
        	    right = dp[idx+1][sum]; 
        	    
        	    dp[idx][sum] = (left + right)%mod;
	        }
	    }
	    
	    return dp[0][0];
	}
	private int memo(int arr[],int n, int sum,int idx,int[][] dp){
	    if(idx == n){
	        if(sum == 0){
	            return 1;
	        }
	        return 0;
	    }
	    
	    if(dp[idx][sum] != -1) return dp[idx][sum];
	    
	    int left = 0,right = 0;
	    if(sum >= arr[idx]){
	        left = memo(arr,n,sum-arr[idx],idx+1,dp);
	    }
	    right = memo(arr,n,sum,idx+1,dp);
	    
	    return dp[idx][sum] = (left + right)%mod;
	}
	
	private int recur(int arr[],int n, int sum,int idx){
	   // if(sum == 0){
	   //     return 1;
	   // }
	    if(idx == n){
	        if(sum == 0){
	            return 1;
	        }
	        return 0;
	    }
	    
	    int left = 0,right = 0;
	    if(sum >= arr[idx]){
	        left = recur(arr,n,sum-arr[idx],idx+1);
	    }
	    right = recur(arr,n,sum,idx+1);
	    
	    return left + right;
	}
}
