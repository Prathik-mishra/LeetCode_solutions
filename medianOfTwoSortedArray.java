class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //brute force approach:
//         int n1 = nums1.length;
//         int n2 = nums2.length;
        
//         ArrayList<Integer> merged = new ArrayList<>();
        
//         int i=0,j=0;
//         while(i<n1 && j<n2){
//             if(nums1[i] < nums2[j]) merged.add(nums1[i++]);
//             else merged.add(nums2[j++]);
//         }
        
//         while(i<n1) merged.add(nums1[i++]);
//         while(j<n2) merged.add(nums2[j++]);
        
//         int size = merged.size();
//         if(size%2 == 1){
//             return (double)(merged.get(size/2));
//         }else{
//             return (double)((double)(merged.get(size/2) + merged.get((size/2)-1))/2.0 );
//         }
        
        //2nd approach optimal: 
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int i=0,j=0;
        int ele1 = -1,ele2 = -1;
        int n = n1+n2;
        int idx1 = (n/2)-1;
        int idx2 = (n/2);
        int cnt = 0;
        
        while(i<n1 && j<n2){
            if(nums1[i] > nums2[j]){
                if(idx1 == cnt) ele1 = nums2[j];
                if(idx2 == cnt) ele2 = nums2[j];
                cnt++;
                j++;
            }else{
                if(idx1 == cnt) ele1 = nums1[i];
                if(idx2 == cnt) ele2 = nums1[i];
                cnt++;
                i++;
            }
        }
        
        while(i<n1){
            if(idx1 == cnt) ele1 = nums1[i];
            if(idx2 == cnt) ele2 = nums1[i];
            cnt++;
            i++;
        }
        
        while(j<n2){
            if(idx1 == cnt) ele1 = nums2[j];
            if(idx2 == cnt) ele2 = nums2[j];
            cnt++;
            j++;
        }
        
        if(n%2 == 1){
            return (double) ele2;
        }else{
            return (double)(ele1+ele2)/2.0;
        }
    }
}