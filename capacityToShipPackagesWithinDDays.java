class Solution {
    int maxValue(int[] weights, int n){
        int  maxValue = weights[0];
        for(int i=1; i<n; i++){
            maxValue = Math.max(maxValue,weights[i]);
        }
        return maxValue;
    }
    
    int sumationOfWeights(int[] weights, int n){
        int sum = weights[0];
        for(int i=1; i<n; i++){
            sum += weights[i]; 
        }
        return sum;
    }
    
    boolean isPossible(int[] weights, int mid, int days){
        int load = 0,possibleDays = 1;
        for(int i=0; i<weights.length; i++){
            if(load+weights[i] > mid){
                load = weights[i];
                possibleDays++;
            }else{
                load += weights[i];
            }
        }
        return possibleDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        //step 1: find out the range:
        int n = weights.length;
        int low = maxValue(weights,n);
        int high = sumationOfWeights(weights,n);
        
        //step 2: perfroming binary search on the taken range
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            
            if(isPossible(weights,mid,days)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}