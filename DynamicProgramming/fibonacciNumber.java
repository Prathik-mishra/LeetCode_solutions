class Solution {
    //Using memoization method:
    public int memo(int n,int[] dp){
        //base case: 
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        //checking wheather the dp has the value of the current index: 
        if(dp[n] != 0) return dp[n];
        
        //calling the recursion to get the further values: 
        int fib_1 = memo(n-1,dp);
        int fib_2 = memo(n-2,dp);
        
        //Using an array dp to memoize the fib terms:
        dp[n] = fib_1 + fib_2;
        
        return fib_1 + fib_2;
     }
    
    public int fib(int n) {
        int[] dp = new int[n+1];
        return memo(n,dp);
    }
}