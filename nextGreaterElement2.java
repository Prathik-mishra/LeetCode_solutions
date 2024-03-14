class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // my approach brute force way: 
//         Stack<Integer> stack = new Stack<>();
        
//         int n = nums.length;
        
//         for(int i = n-1 ; i >= 0 ; i--){
//             stack.push(nums[i]);
//         }
        
//         for(int i = n-1 ; i >= 0 ; i-- ){
//             int num = nums[i];
            
//             while(!stack.isEmpty() && stack.peek() <= num){
//                 stack.pop();
//             }
            
//             nums[i] = stack.isEmpty() ? -1 : stack.peek();
            
//             stack.push(num);  
//         }
//         return nums;
        
        // int[] res = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     res[i] = -1;
        //     for (int j = 1; j < nums.length; j++) {
        //         if (nums[(i + j) % nums.length] > nums[i]) {
        //             res[i] = nums[(i + j) % nums.length];
        //             break;
        //         }
        //     }
        // }
        // return res;
        
        
        int[] res = new int[nums.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
        
    }
}