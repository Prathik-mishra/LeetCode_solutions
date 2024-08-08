class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> Integer.compare(a.length(),b.length()));
        int n = words.length, max = 0;
        int[] dp = new int[n];

        for(int i=0; i<n; i++) dp[i] = 1; //since all the sequence are itself value as 1

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(compare(words[i],words[j]) && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }

    private boolean compare(String s1, String s2){
        // here s1 is the big str and s2 is shorter one
        if(s1.length() != s2.length()+1) return false;
        int i=0, j=0;

        while(i<s1.length()){
            if(j<s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }

        if(i == s1.length() && j == s2.length()) return true;
        return false;
    }
}
