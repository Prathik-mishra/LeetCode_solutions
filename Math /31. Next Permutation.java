class Solution {
    public void nextPermutation(int[] nums) {
        //traversing through the array to find the dip: 
        int idx = -1;
        for(int i = nums.length-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        
        //checking if the array has no dip and if it is true then reversing the array assuming it as the next permutation: 
        if(idx == -1){
            int i = 0,j = nums.length-1;
            while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            return;
        }
        
        //swaping the dip number if there exists a nearest greater number of the dip element:
        for(int i = nums.length-1 ; i > idx ; i--){
            if(nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        
        //reversing the array from idx to end:
        int i = idx+1,j = nums.length-1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
