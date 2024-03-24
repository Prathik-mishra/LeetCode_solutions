class Solution {
    public int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        if(freq[0] < k || freq[1] < k || freq[2] < k){
            return -1;
        }
        
        int ans = freq[0]+freq[1]+freq[2];
        int st = 0;
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']--;
            
            if(freq[0] < k || freq[1] < k || freq[2] < k){
                ans = Math.min(freq[0]+freq[1]+freq[2]+1,ans);
                
                while(s.charAt(st) != ch){
                    freq[s.charAt(st++) - 'a']++;
                }
                
                freq[ch-'a']++;
                st++;
            }
        }
        return Math.min(freq[0]+freq[1]+freq[2],ans);
    }
}