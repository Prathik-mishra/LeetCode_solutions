class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        // return  func(s,0);
        // int[] dp = new int[s.length()];
        // Arrays.fill(dp,-1);
        // return func(s,0,dp);

        return tabulation(s);
    }

    private int tabulation(String s){
        int n = s.length();
        int[] dp = new int[n+1];

        dp[n] = 1;

        for(int idx=n-1; idx>=0; idx--){
            if(s.charAt(idx) == '0'){
                dp[idx] = 0;
                continue;
            }

            if(idx+2 <= s.length() && Integer.parseInt(s.substring(idx,idx+2)) <= 26){
                dp[idx] = dp[idx+1] + dp[idx+2]; 
            }else{
                dp[idx] = dp[idx+1];
            }
        }
        
        return dp[0];
    }

    private int func(String s, int idx, int[] dp){
        if(idx == s.length()){
            return 1;
        }

        if(s.charAt(idx) == '0'){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        if(idx+2 <= s.length() && Integer.parseInt(s.substring(idx,idx+2)) <= 26){
            return dp[idx] = func(s,idx+1,dp) + func(s,idx+2,dp);
        }else{
            return dp[idx] = func(s,idx+1,dp);
        }

    }

    private int func(String s, int idx){
        if(idx == s.length()){
            return 1;
        }

        if(s.charAt(idx) == '0'){
            return 0;
        }

        if(idx+2 <= s.length() && Integer.parseInt(s.substring(idx,idx+2)) <= 26){
            return func(s,idx+1) + func(s,idx+2);
        }else{
            return func(s,idx+1);
        }

    }
}
