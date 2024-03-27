class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        for(int i : nums){
            hmap.put(i,hmap.getOrDefault(i,0)+1);
        }
        
        //using bucket sort algo here:
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        for(Integer key : hmap.keySet()){
            int freq = hmap.get(key);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        int[] res = new int[k];
        int idx = 0;
        for(int pos = bucket.length-1 ; pos >= 0 && idx != k; pos--){
            if(bucket[pos] != null){
               for(int i : bucket[pos]){
                    if(idx == k){
                        return res;
                    }
                res[idx++] = i;
                } 
            }  
        }
        return res;
    }
}
