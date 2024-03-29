class Solution {
    int maxValue(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            max = Math.max(piles[i],max);
        }
        return max;
    }
    
    boolean isPossible(int[] piles, int mid, int h){
        int totalHours = 0;
        int n = piles.length;
        
        for(int i=0 ; i<n ; i++){
            totalHours += Math.ceil((double) piles[i]/(double) mid);
        }
        return totalHours<=h;
    } 
    
    public int minEatingSpeed(int[] piles, int h) {
        // step 1: determining the range
        int low = 1;
        int high = maxValue(piles);
        
        //step 2: perform the binary search algorithm
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            
            //step 3: check wheather the value is possible or not
            if(isPossible(piles,mid,h)){
                ans = Integer.min(ans,mid);  //update the latest min answer possible
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
