class Solution {
    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        // return func(s,0)-1;

        // int[] dp = new int[s.length()];
        // Arrays.fill(dp,-1);
        // return func(s,0,dp)-1;

        // return tabulation(s);
        /* above all the approaches gives TLE cause of stringconcatination in takes much time and space below is the accepted solution */
        
        return palindromePartitioning(s);
    }

    private int palindromePartitioning(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i=n-1; i>=0; i--) {
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, str)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }

    private int tabulation(String s){
        int n = s.length();
        int[] dp = new int[n+1];

        dp[n] = 0;

        for(int i=n-1; i>=0; i--){
            int minPart = Integer.MAX_VALUE;
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<s.length(); j++){
                
                sb.append(s.charAt(j));
                if(isPalindrome(sb.toString())){
                    int currPart = 1 + dp[j+1];//func(s,j+1,dp);
                    minPart = Math.min(minPart,currPart);
                }
            } 

            dp[i] = minPart;
        }

        return dp[0]-1;
    }

    private int func(String s, int i,int[] dp){
        if(i == s.length()){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int minPart = Integer.MAX_VALUE;
        String currStr = "";
        for(int j=i; j<s.length(); j++){
            
            currStr += s.charAt(j);
            if(isPalindrome(currStr)){
                int currPart = 1 + func(s,j+1,dp);
                minPart = Math.min(minPart,currPart);
            }
        } 

        return dp[i] = minPart;
    }

    private int func(String s, int i){
        if(i == s.length()){
            return 0;
        }

        int minPart = Integer.MAX_VALUE;
        String currStr = "";
        for(int j=i; j<s.length(); j++){
            
            currStr += s.charAt(j);
            if(isPalindrome(currStr)){
                int currPart = 1 + func(s,j+1);
                minPart = Math.min(minPart,currPart);
            }
        } 

        return minPart;
    }
}
