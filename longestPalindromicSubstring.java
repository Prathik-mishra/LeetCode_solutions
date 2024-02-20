class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int longLen = 0;
        for(int i=0; i<s.length(); i++){
            //for odd length:
            int left = i,right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if((right-left+1) > longLen){
                    res = s.substring(left,right+1);
                    longLen = (right-left+1);
                }
                left--;
                right++;
            }
            
            //for even length:
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if((right-left+1) > longLen){
                    res = s.substring(left,right+1);
                    longLen = (right-left+1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}