class Solution {
    // private String reverse(String s){
    //     StringBuilder sb = new StringBuilder();
    //     for(int i=s.length()-1; i>=0; i--){
    //         sb.append(s.charAt(i));
    //     }
    //     return sb.toString();
    // }

    public int longestPalindromeSubseq(String s) {
        // There are two methods to solce this problem one being that we can reverse the same string and find the longest common subsequence(lcs) which will be our answer Striver approach:
        // int n = s.length(), m = s.length();
        // int[][] dp = new int[n+1][m+1];
        // String text1 = s;
        // String text2 = reverse(s);
        // //these 2 for loops be removed since the default value is 0  
        // // for(int i=0; i<=n; i++) dp[i][0] = 0;
        // // for(int i=0; i<=m; i++) dp[0][i] = 0;
        
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=m; j++){
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         }else{
        //             dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }
        // }
        
        // return dp[n][m];


        // second one is that we can use of gap stratergy and solve it by tabulation directly and is more simple:

        //gap stratergy approach : 
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int gap = 0; gap < n; gap++){
            for(int i=0, j=gap ; j<n; i++, j++){
                if(i == j){
                    dp[i][j] = 1;
                } 
                else if((j-i+1) == 2){
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 1;
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1],Math.max(dp[i+1][j-1], dp[i+1][j]));
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
