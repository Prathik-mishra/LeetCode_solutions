class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastOcc = new int[26];
        
        for(int i=0; i<n; i++){
            lastOcc[s.charAt(i) - 'a'] = i;
        } 
        
        List<Integer> ans = new ArrayList<>();
        
        int j = 0, lastPartitionIdx = 0;
        for(int i=0; i<n; i++){
            j = Math.max(j,lastOcc[s.charAt(i) - 'a']);
            if(i == j){
                ans.add(i-lastPartitionIdx+1);
                lastPartitionIdx = i+1;
            }
        }
        return ans;
    }
}