class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int i : nums1){
            s1.add(i);
        }

        for(int i : nums2){
            s2.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i : s1){
            if(s2.contains(i)){
                list.add(i);
            }
        }
        
        int[] res = new int[list.size()];
        int idx = 0;
        for(int i : list){
            res[idx++] = i;
        }
        return res;
    }
}
