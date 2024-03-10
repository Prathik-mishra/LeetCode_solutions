class Solution {
    //creating is possible function to curate the possible value
    boolean isPossible(int[] arr, int divisor, int threshold){
        int sumOfQuotient = 0;
        for(int i=0; i<arr.length; i++){
            sumOfQuotient += Math.ceil((double)arr[i]/(double) divisor);
        }
        return sumOfQuotient <= threshold;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        //using binary search on answers concept here:
        //step 1: find the range
        //step 2: perform binary search on the range 
        //step 3: check wheather the answer can be the posssible to fit in the threshold 
        
        int n = nums.length;
        int maxValue = nums[0];
        for(int i=0; i<n; i++){
            maxValue = Math.max(maxValue,nums[i]);
        }
        int low = 1;
        int high = maxValue;
        int ans = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(isPossible(nums, mid , threshold)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}