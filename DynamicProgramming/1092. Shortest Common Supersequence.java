class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = lcs(str1,str2);
        int i=str1.length(), j=str2.length();

        StringBuilder sb = new StringBuilder();

        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i][j-1] >= dp[i-1][j]){
                sb.append(str2.charAt(j-1));
                j--;
            }else{
                sb.append(str1.charAt(i-1));
                i--;
            }
        }

        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    private int[][] lcs(String text1, String text2){
        int n = text1.length() , m = text2.length(); 
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp;
    }
}
