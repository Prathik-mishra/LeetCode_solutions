import java.util.*;

class Solution {
    private int recur(int[] jump,int idx){
        if(idx == jump.length){
            return 1;
        }

        int val = 0;
        for(int i=1; i <= jump[idx] && i+idx <= jump.length ; i++){
            val += recur(jump,idx+i);
        }

        return val;
    }

    private int memo(int[] jump,int idx, int[] dp){
        if(idx == jump.length){
            return 1;
        }

        if(dp[idx] > 0) return dp[idx];
        
        int val = 0;
        for(int i=1; i <= jump[idx] && i+idx <= jump.length ; i++){
            val += memo(jump,idx+i,dp);
        }

        return dp[idx] = val;
    }

    private int tab(int[] jump, int[] dp){
        for(int idx=jump.length; idx>=0; idx--){
            if(idx == jump.length){
                dp[idx] = 1;
                continue;
            }
        
            int val = 0;
            for(int i=1; i <= jump[idx] && i+idx <= jump.length ; i++){
                val += dp[idx+i]; //memo(jump,idx+i,dp);
            }

            dp[idx] = val;
        }
        return dp[0];
    }
    
    public int stairWays(int[] jump) {
        //Write code here
        // return recur(jump,0);
        int[] dp = new int[jump.length+1];
        // return memo(jump,0,dp);
        return tab(jump,dp);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.stairWays(arr);
        System.out.println(res);
        sc.close();
    }
}
