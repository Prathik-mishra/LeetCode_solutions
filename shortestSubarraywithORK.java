class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minSize = n+1;
        
        for(int i=0; i<n; i++){
            
            int or = nums[i];
            if(or >= k) return 1;
            
            for(int j=i+1; j<n; j++){
                or = or | nums[j];
                if(or >= k){
                    minSize = Math.min(minSize,(j-i+1));
                }
            }
        }
        
        if(minSize == n+1){
            return -1;
        }else{
            return minSize;
        }
    }
}
