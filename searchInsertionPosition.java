class Solution {
    public int searchInsert(int[] nums, int target) {
        
        //Brute force approach: 
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(target == nums[i]){
        //         return i;
        //     }
        //     if(nums[i] > target){
        //         return i;
        //     }
        // }
        // return nums.length;
        
        //optimal approach:
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (nums[mid] >= target) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}