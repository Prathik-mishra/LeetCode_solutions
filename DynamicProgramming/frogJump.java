import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        //for recusrion:
        // return recur(n-1,heights);

        //for memoization:
        // int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        // return memo(n-1,heights,dp);

        //for tabulation:
        /*
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i=1; i<n; i++){
            int firstStep = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int secondStep = (i>1) ? dp[i-2] + Math.abs(heights[i] - heights[i-2]) : Integer.MAX_VALUE;

            dp[i] = Math.min(firstStep,secondStep);
        }

        return dp[n-1];
        */

        //space optimization:
        int prev = 0;
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int firstStep = prev + Math.abs(heights[i] - heights[i-1]);
            int secondStep = (i>1) ? prev2 + Math.abs(heights[i] - heights[i-2]) : Integer.MAX_VALUE;

            int curr = Math.min(firstStep,secondStep);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static int recur(int idx, int[] heights){
        if(idx == 0){
            return 0;
        }

        int left = Math.abs(heights[idx]-heights[idx-1]) + recur(idx-1,heights);
        int right = (idx>1) ? Math.abs(heights[idx]-heights[idx-2]) + recur(idx-2,heights) : Integer.MAX_VALUE;

        return Math.min(left,right);
    }

    public static int memo(int idx, int[] heights,int[] dp){
        if(idx == 0){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int left = Math.abs(heights[idx]-heights[idx-1]) + memo(idx-1,heights,dp);
        int right = (idx>1) ? Math.abs(heights[idx]-heights[idx-2]) + memo(idx-2,heights,dp) : Integer.MAX_VALUE;

        return dp[idx] = Math.min(left,right);
    }
}
