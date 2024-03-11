class Solution {
    private int isPossible(int[] nums,int mid,int k){
        int noOfPainters = 1;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]+sum > mid){
                sum = nums[i];
                noOfPainters++;
            }else{
                sum += nums[i];
            }
        }
        return noOfPainters;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        //edge case:
        if(k > n) return -1;
        // step 1: find the range in which answer could be present
        int maxValue = nums[0];
        int sumOfnums = nums[0];
        for(int i=1; i<n; i++){
            maxValue = Math.max(maxValue,nums[i]);
            sumOfnums += nums[i];
        }
        int low = maxValue;
        int high = sumOfnums;
        
        // step 2: perform binary search on the range specified above:
        while(low <= high){
            int mid = (low+high)/2;
            
            int maxValOfSum = isPossible(nums,mid,k);
            
            if(maxValOfSum > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}