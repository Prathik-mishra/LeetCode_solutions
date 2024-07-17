import java.io.*;
import java.util.*;
class Solution{
    private static int recur(int[] jumps,int idx){
        if(idx >= jumps.length){
            return 0;
        }
        int minSteps = (int) 1e4;
        for(int i=1; i<=jumps[idx] ; i++){
            int currentVal = recur(jumps,idx+i);
            minSteps = Math.min(currentVal,minSteps);
        }
        return minSteps + 1;
    }

    private static int memo(int[] jumps,int idx,int[] dp){
        if(idx >= jumps.length){
            return 0;
        }
        if(dp[idx] != 0) return dp[idx];
        
        int minSteps = (int) 1e4;
        for(int i=1; i<=jumps[idx] ; i++){
            int currentVal = memo(jumps,idx+i,dp);
            minSteps = Math.min(currentVal,minSteps);
        }
        
        return dp[idx] = minSteps + 1;
    }

    private static int tab(int[] jumps){
        int[] dp = new int[jumps.length+1];
        
        for(int idx=jumps.length; idx>=0; idx--){
            if(idx >= jumps.length){
                dp[idx] = 0;
                continue;
            }
            
            int minSteps = (int) 1e4;
            for(int i=1; i<=jumps[idx] && idx+i<=jumps.length ; i++){
                int currentVal = dp[idx+i];//memo(jumps,idx+i,dp);
                minSteps = Math.min(currentVal,minSteps);
            }
            
            dp[idx] = minSteps + 1;
        }
        return dp[0];
    }
    
    public static int minJumps(int []jumps){
        //write your code here
        // return recur(jumps,0);
        // int[] dp = new int[jumps.length+1];
        // return memo(jumps,0,dp);
        return tab(jumps);
    }
}
public class Main {

   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = sc.nextInt();
      }



      System.out.println(Solution.minJumps(arr));
   }

}
