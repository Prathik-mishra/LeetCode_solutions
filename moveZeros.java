class Solution {
    public void moveZeroes(int[] nums) {
        // int j = -1;
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] == 0){
        //         j = i;
        //         break;
        //     }
        // }
        // //if array dosent contains any zeros or size is one return the array itself:
        // if(j == -1 || nums.length == 1){
        //     return;
        // }
        // for(int i = j+1 ; i < nums.length ; i++){
        //     if(nums[i] != 0){
        //         int temp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = temp;
        //         j++;
        //     }
        // }
        // return;
        
        // int p1 = 0;
        // for(int p2 = 1; p2 < nums.length ; p2++){
        //    if(nums[p2] != 0 && nums[p1] == 0){
        //        int temp = nums[p1];
        //        nums[p1] = nums[p2];
        //        nums[p2] = temp;
        //        p1++;
        //    }else if(nums[p1] != 0){
        //        p1++;
        //    }
        // }
        
    //       int j = 0;
    // for(int i = 0; i < nums.length; i++) {
    //     if(nums[i] != 0) {
    //         int temp = nums[j];
    //         nums[j] = nums[i];
    //         nums[i] = temp;
    //         j++;
    //     }
    // }
        
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) nums[index++]=nums[i];
        }
        while(index<nums.length){
            nums[index++]=0;
        }
    }
}