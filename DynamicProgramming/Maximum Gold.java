import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int M[][] = new int[n][m];
        for(int i = 0;i < n*m;i++){
            M[i/m][i%m] = sc.nextInt();
        }
        
        Solution ob = new Solution();
        System.out.println(ob.maxGold(n, m, M));
    }
} 

class Solution{
    static int maxGold(int n, int m, int M[][]){
        //Write code here
        //recursion solution : 
        /*
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxVal = Math.max(maxVal,recur(M,i,0));
        }
        return maxVal;
        */
        
        //memoization solution : 
        /*
        int maxVal = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            maxVal = Math.max(maxVal,memo(M,i,0,dp));
        }
        return maxVal;
        */
        
        //tabulation approach: 
        return tab(M);
    }   

    static int recur(int M[][], int i, int j){
        if(i<0 || i>=M.length || j < 0 || j>=M[0].length){
            return Integer.MIN_VALUE;
        }

        if(j == M[0].length-1){
            return M[i][j];
        }

        int digUp = recur(M,i-1,j+1);
        int right = recur(M,i,j+1);
        int digDown = recur(M,i+1,j+1);

        return M[i][j] + Math.max(digUp,Math.max(right,digDown));
    }

    static int memo(int M[][], int i, int j,int[][] dp){
        if(i<0 || i>=M.length || j < 0 || j>=M[0].length){
            return Integer.MIN_VALUE;
        }

        if(j == M[0].length-1){
            return M[i][j];
        }

        if(dp[i][j] != 0) return dp[i][j];
        
        int digUp = memo(M,i-1,j+1,dp);
        int right = memo(M,i,j+1,dp);
        int digDown = memo(M,i+1,j+1,dp);

        return dp[i][j] = M[i][j] + Math.max(digUp,Math.max(right,digDown));
    }

    static int tab(int M[][]){
        int[][] dp = new int[M.length][M[0].length];
        for(int j=M[0].length-1; j>=0; j--){
            for(int i=M.length-1; i>=0; i--){
              
                if(j == M[0].length-1){
                    dp[i][j] =  M[i][j];
                    continue;
                }
                
                int digUp = (i-1>=0 && i-1<M.length && j+1 >= 0 && j+1<M[0].length) ? dp[i-1][j+1] : Integer.MIN_VALUE; 
                int right = (i>=0 && i<M.length && j+1 >= 0 && j+1<M[0].length) ? dp[i][j+1] : Integer.MIN_VALUE;
                int digDown = (i+1>=0 && i+1<M.length && j+1 >= 0 && j+1<M[0].length) ? dp[i+1][j+1] : Integer.MIN_VALUE;
        
                dp[i][j] = M[i][j] + Math.max(digUp,Math.max(right,digDown));
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<M.length; i++){
            maxVal = Math.max(maxVal,dp[i][0]);
        }
        return maxVal;
    }
}
