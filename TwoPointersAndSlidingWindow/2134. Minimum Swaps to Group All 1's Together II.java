class Solution {
    public int minSwaps(int[] nums) {
        int minSwaps = Integer.MAX_VALUE;
        int n = nums.length, end = 0, currZerosCount = 0;
        int totalOnesCount = getCount(nums);
        int i = 0;

        while(i < n){
            currZerosCount += (nums[end%n] == 0) ? 1 : 0;

            if(end - i + 1 > totalOnesCount){
                currZerosCount -= (nums[i] == 0) ? 1 : 0;
                i++;
            }

            if(end - i + 1 == totalOnesCount){
                minSwaps = Math.min(minSwaps,currZerosCount);
            }
            end++;
        }

        return minSwaps;
    }

    private int getCount(int[] nums){
        int count = 0;
        for(int i : nums){
            count += i;
        }
        return count;
    }
}
