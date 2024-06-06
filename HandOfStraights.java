class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        
        if(n % groupSize != 0){
            return false;
        }
        
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        
        for(int i=0; i<n; i++){
            tmap.put(hand[i],tmap.getOrDefault(hand[i],0) + 1);
        }
        
        while(tmap.size() > 0){
            int currentNum = tmap.entrySet().iterator().next().getKey();;
            
            for(int i=0; i<groupSize; i++){
                if(!tmap.containsKey(currentNum+i)){
                    return false;
                }
                tmap.put(currentNum+i,tmap.getOrDefault(currentNum+i,0) - 1);
                if(tmap.get(currentNum+i) == 0){
                    tmap.remove(currentNum+i);
                }
            }
        }
        return true;
    }
}
