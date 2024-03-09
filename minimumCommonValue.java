class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        //approach 1: hashSet
        /*
        Set<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }

        for(int i : nums2){
            if(set.contains(i)){
                return i;
            }
        }
        
        return -1;
        */

        //approach 2: two pointers
        /*
        int p1 = 0,p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                return nums1[p1];
            }

            if(nums1[p1] < nums2[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        return -1;
        */

        //
        // Binary search should be done on the larger array
        // If nums1 is longer, call getCommon with the arrays swapped
        if (nums1.length > nums2.length) {
            return getCommon(nums2, nums1);
        }
        
        // Search for each element of nums1 in nums2
        // Return the first common element found
        for (int num : nums1) {
            if (binarySearch(num, nums2)) {
                return num;
            }
        }

        // Return -1 if there are no common elements
        return -1;
    }

    private boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
