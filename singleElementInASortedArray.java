class Solution {
    public int singleNonDuplicate(int[] nums) {
        //1st approach: T.C:- (N)
        // if(nums.length == 1) return nums[0];
        // for(int i=0; i<nums.length; i++){
        //     if(i == 0 && nums[i] != nums[i+1]) return nums[i];
        //     else if(i == nums.length-1 && nums[i] != nums[i-1]) return nums[i];
        //     else if(i!= 0 && i!=nums.length-1 && nums[i] != nums[i-1] && nums[i] != nums[i+1]) return nums[i];
        // }
        // return -1;
        
        //2nd approach by binary search:
        int n = nums.length;
        //some edge cases to trim down the search space too...
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-2] != nums[n-1]) return nums[n-1];
        
        int low = 0;
        int high = n-1;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            //condition to fing the answer:
            if(nums[mid] != nums[mid-1] && nums[mid+1] != nums[mid]) return nums[mid];
            
            //condition for binary search operations: 
            if((mid%2 == 1 && nums[mid] == nums[mid-1]) || (mid%2 == 0 && nums[mid] == nums[mid+1])){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
