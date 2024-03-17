class Solution {
    public long countSubstrings(String s, char c) {
        long res = 0,x = 0;
        int n = s.length();

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == c) {
                x++;
                res += x; 
            }
        }
        
        return res; 
    }
}
