class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int left = 0,right = n-1;
        int left_Max = 0,right_Max = 0,result = 0;
        
        while(left <= right){
            
            if(height[left] <= height[right]){
                
                if(height[left] >= left_Max) left_Max = height[left];
                else result += left_Max-height[left];
                    
                left++;
            }else{
                
                if(height[right] >= right_Max) right_Max = height[right];
                else result += right_Max-height[right];
                right--;
            }
        }
        return result;
        
        //saksham sir approach: T.C :- O(2N) and S.C :- O(2N) it is a better approach:
        
        //we habe used the concept of prefix and suffix max in this problem it becomes more intutive that way and to find the answer we made a formula water_storedonthatindex = min(max(left,max(right)) - current_height) and this gives us the final answer 
//         int n = n = height.length;
//         int[] prefixMax = new int[n];
//         int[] suffixMax = new int[n];
//         int left_max = 0,right_max = 0;
//         int final_sum = 0;
        
//         for(int i = 0  ; i < n ; i++){
//             if(left_max < height[i]){
//                 left_max = height[i];
//                 prefixMax[i] = left_max;
//             }else{
//                 prefixMax[i] = left_max;
//             }
            
//             if(right_max < height[n-1-i]){
//                 right_max = height[n-1-i];
//                 suffixMax[n-1-i] = right_max;
//             }else{
//                 suffixMax[n-1-i] = right_max;
//             }
//         }
        
//         for(int i = 0 ; i < n ; i++){
//             int water_stored = Math.min(prefixMax[i],suffixMax[i]) - height[i];
//             final_sum += water_stored;
//         }
        
//         return final_sum;
    }
}
