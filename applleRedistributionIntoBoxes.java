class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sumOfApples = 0;
        for(int i : apple){
            sumOfApples += i;
        }
        
        Arrays.sort(capacity);
        int count = 0,idx = capacity.length-1;
        
        while(sumOfApples != 0){
            if(capacity[idx] <= sumOfApples){
                sumOfApples -= capacity[idx];
                count++;
            }else{
                count++;
                break;
            }
            idx--;
        }
        
        return count;
    }
}
