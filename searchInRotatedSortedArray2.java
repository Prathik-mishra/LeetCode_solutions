class Solution {
    public boolean search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = (start+end)/2;
            
            if(nums[mid] == target) return true;
            
            //important condition: 
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                //if this condition is true then we shrink the searching space by one place from beginning and at the end
                start = start+1;
                end = end-1;
                continue;
            }
            
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return false;
    }
}