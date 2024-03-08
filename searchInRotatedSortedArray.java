class Solution {
    public int search(int[] nums, int target) {
        
        //simple brute force approach with TC :- O(n) 
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] == target) return i;
        // }
        // return -1;
        
        //binary search approach which will TC :- O(log n)
        /*about the approach: 
        1.first we go with the normal binary search approach 
        2. if the mid is not required element then we try to check wheather out array is sorted or not and try if it is true then we then we see the possibility of element present in that search range if it is also true then we go further and check in that specific search range. 
        
        
        */
        int low = 0,high = nums.length-1;
        while(low <= high){
            int mid = (low + high)/2;          
            
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}