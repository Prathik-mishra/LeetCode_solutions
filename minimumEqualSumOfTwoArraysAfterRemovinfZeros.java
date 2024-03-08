class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long n = nums1.length;
        long m = nums2.length;
        
        long zeros_1 = 0;
        long zeros_2 = 0;
        
        long sum_1 = 0;
        long sum_2 = 0;
        
        for(int i=0; i<n; i++){
            sum_1 += nums1[i];
            if(nums1[i] == 0){
                sum_1++;
                zeros_1++;
            }
        }
        
        for(int i=0; i<m; i++){
            sum_2 += nums2[i];
            if(nums2[i] == 0){
                sum_2++;
                zeros_2++;
            }
        }
        
        if(sum_1 == sum_2){
            return sum_1;
        }else{
            if(sum_1 < sum_2){
                if(zeros_1 > 0){
                    return sum_2;
                }else{
                    return -1;
                }
            }else{
                if(zeros_2 > 0){
                    return sum_1;
                }else{
                    return -1;
                }
            }
        }
    }
}