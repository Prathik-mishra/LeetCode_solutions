class Solution {
    public int minimumLevels(int[] possible) {
        int ans = -1;
        int length = possible.length;
        
        int Tzero = 0;
        int Tone = 0;
        
        for(int i : possible){
            if(i == 1) Tone++;
            else Tzero++;
        }
        
        int currOne = 0;
        int currZero = 0;
        
        for(int i=0; i<length-1; i++){
            if(possible[i] == 1){
                currOne++;
            }else{
                currZero++;
            }
            
            int Apoints = (1*currOne) + ((-1)*currZero);
            int Bpoints = (1*(Tone - currOne)) + ((-1)*(Tzero - currZero));
            
            if(Apoints > Bpoints){
                ans = i+1;
                break;
            }
        }
        return ans;
    }
}
