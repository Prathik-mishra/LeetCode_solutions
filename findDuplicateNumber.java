class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }

        return len;
        
        // int total = 0,curT = 0;
        // for(int i=0; i<nums.length; i++){
        // total += (i+1);
        // curT += nums[i];
        // }
        // return nums.length - (total-curT);
    }
}