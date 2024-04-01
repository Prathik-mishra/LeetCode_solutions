class Solution {
    public int numberOfSubstrings(String s) {
        int[] pos = new int[3];
        int count = 0;
        for(int i=0; i<3; i++){
            pos[i] = -1;
        }
        int j=0,n=s.length();
        while(j<n){
            char ch = s.charAt(j);
            pos[ch-'a'] = j;
            
            if(pos[0] != -1 && pos[1] != -1 && pos[2] != -1){ 
                count += Math.min(Math.min(pos[0],pos[1]),pos[2])+1;
            }
            j++;
        }
        return count;
    }
}
