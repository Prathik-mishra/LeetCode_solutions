import java.util.* ;
import java.io.*;
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        
        //Recursion approach:
        // return recur(n-1,k,height);

        //memoization approach;
        // int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        // return memo(n-1,k,height,dp);

        //tabulation approach:
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i=1; i<n; i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j >= 0){
                    int steps = dp[i-j] + Math.abs(height[i] - height[i-j]);
                    minSteps = Math.min(steps,minSteps);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
    }

    public static int recur(int n, int k, int[] heights){
        //base case:
        if(n == 0){
            return 0;
        }
        
        int minSteps = Integer.MAX_VALUE;
        //since i have to take k steps we can call k recur functions
        for(int i=1; i<=k; i++){
            if(n-i >= 0){
                int steps = Math.abs(heights[n] - heights[n-i]) + recur(n-i,k,heights);
                 minSteps = Math.min(minSteps,steps);
            }
        }

        return minSteps;
    }

    public static int memo(int n, int k, int[] heights,int[] dp){
        //base case:
        if(n == 0){
            return 0;
        }
        //memoization step:
        if(dp[n] != -1) return dp[n];

        int minSteps = Integer.MAX_VALUE;
        //since i have to take k steps we can call k recur functions
        for(int i=1; i<=k; i++){
            if(n-i >= 0){
                int steps = Math.abs(heights[n] - heights[n-i]) + memo(n-i,k,heights,dp);
                minSteps = Math.min(minSteps,steps);
            }
        }

        return dp[n] = minSteps;
    }
}