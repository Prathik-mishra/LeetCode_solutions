class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        
        for(int i=2; i<n; i++){
            if(list1.get(list1.size()-1) >= list2.get(list2.size()-1)){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }
        
        int[] ans = new int[n];
        int idx = 0,i = 0;
        
        while(idx < list1.size()){
            ans[i++] = list1.get(idx++);
        }
        
        idx = 0;
        while(idx < list2.size()){
            ans[i++] = list2.get(idx++);
        }
        
        return ans;
    }
}
