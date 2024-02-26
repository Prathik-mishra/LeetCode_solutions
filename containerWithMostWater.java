class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int n = height.length;
        int left_side = 0;
        int right_side = n-1;
        while(left_side<right_side){
            if(height[left_side] <= height[right_side]){
                maxWater = Math.max(maxWater,height[left_side]*(right_side-left_side));
                left_side++;
            }else{
                maxWater = Math.max(maxWater,height[right_side]*(right_side-left_side));
                right_side--;
            }
        }
        return maxWater;
    }
}