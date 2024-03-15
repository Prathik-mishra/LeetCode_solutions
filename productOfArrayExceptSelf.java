class Solution {
    public int[] productExceptSelf(int[] nums) {
        //brute force: 
        // int arr[] = new int[nums.length];
        // for(int i = 0 ; i < nums.length ; i++){
        //     int product = 1;
        //     for(int j = 0 ; j < nums.length ; j++){
        //         if(i!=j){
        //             product = product*nums[j];
        //         }
        //     }
        //     arr[i] = product;
        // }
        // return arr;
        
        //approach 1:
//         int n = nums.length;
//         int[] left_prod = new int[n];
//         int[] right_prod = new int[n];
        
//         left_prod[0] = 1;
//         right_prod[n-1] = 1;
        
//         for(int i = 1 ; i < n ; i++){
//             left_prod[i] = nums[i-1] * left_prod[i-1];
//         }
        
//         for(int i = n-2 ; i >= 0 ; i--){
//             right_prod[i] = nums[i+1] * right_prod[i+1];
//         }
        
//         for(int i = 0 ; i < n ; i++){
//             nums[i] = left_prod[i] * right_prod[i];
//         }
        
//         return nums;
        
        //approach 2: 
        int n = nums.length;
        int[] output_arr = new int[n];
        output_arr[0] = 1;
        
        
        for(int i = 1; i < n ; i++){
            output_arr[i] = output_arr[i-1] * nums[i-1];
        }
        
        int R = 1;
        for(int i = n-1 ; i >= 0 ; i--){
            output_arr[i] = output_arr[i] * R;
            R = R * nums[i];
        }
        
        return output_arr;
    }
}