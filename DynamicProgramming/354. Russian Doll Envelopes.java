class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0] == b[0]) return -Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        
        TreeSet<Integer> tset = new TreeSet<>();
        
        for(int i=0; i<envelopes.length; i++){
            int top = envelopes[i][1];
            Integer ceilVal = tset.ceiling(top);
            if(ceilVal != null) tset.remove(ceilVal);
            tset.add(top);
        }
        
        return tset.size();
    }
}
