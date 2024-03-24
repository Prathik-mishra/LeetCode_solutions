class Solution {
    public int maximumLengthSubstring(String s) {
        
        int[] freq = new int[26];
        int i=0,j=0;
        int maxLen = 0;
        
        while(i < s.length()){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            
//             while(j < i && freqCheck(freq) > 2){
//                 freq[s.charAt(j)-'a']--;
//                 j++;
//             }
            
//             maxLen = Math.max(maxLen,i-j+1);
//             i++;
            while(j < i && freqCheck(freq)){
                freq[s.charAt(j)-'a']--;
                j++;
            }
            
            maxLen = Math.max(maxLen,i-j+1);
            i++;
        }
        return maxLen;
    }
    
    public boolean freqCheck(int[] freq){
        int maxFreq = 0;
        for(int i : freq){
            maxFreq = Math.max(maxFreq,i);
        }
        return maxFreq>2;
    }
}