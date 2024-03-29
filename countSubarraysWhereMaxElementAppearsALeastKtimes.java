class Solution {
    public long countSubarrays(int[] nums, int k) {
       long ans = 0, n = nums.length;
       int maxEle = 0;
       for(int i : nums){
          maxEle = Math.max(i,maxEle);
       }
        
        int start = 0, end = 0, count = 0;
        
        while(end < n){
            if(nums[end] == maxEle){
                count++;
            }
            
            //valid window start counting the elements based on the valid subarrays ending point - n + 1 and add it to answer
            while(start <= end && count >= k){
                ans += (n-end);
                if(nums[start] == maxEle){
                    count--;
                }
                start++;
            }
            
            end++;
        }
        return ans;
    }
}