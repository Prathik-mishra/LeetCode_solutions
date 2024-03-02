class Solution {
    public int majorityElement(int[] nums) {
        //approach 1: 
//         int cnt = 0, el = 0 , n = nums.length;
//         for(int i = 0 ; i < n ; i++){
//             if(cnt == 0){
//                 cnt = 1;
//                 el = nums[i];
//             }else if(el == nums[i]){
//                 cnt++;
//             }else{
//                 cnt--;
//             }
//         }
        
//         int cnt1 = 0;
//         for(int i = 0 ; i < n ; i++){
//             if(nums[i] == el) cnt1++;
//         }
        
//         if(cnt1 > n/2) return el;
//         return -1;
        
        //approach 2: (not best but works)
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}
