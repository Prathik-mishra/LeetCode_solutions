class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        //1st approach
        long happinessCount = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> -Integer.compare(a,b));
        
        for(int i : happiness){
            pq.offer(i);
        }
        
        long reduction = 0;
        while(k > 0){
            if(pq.peek()-reduction > 0){
                happinessCount += (pq.remove()-reduction);
            }else{
                pq.remove();
            }
            
            reduction++;
            k--;
        }
        
        return happinessCount;
        
        // 2nd approach:
        // Arrays.sort(happiness);
        // long happinessCount = 0;
        // long reduction = 0;
        // for(int i = happiness.length-1; i >=0; i--){
        //     happinessCount += Math.max(0,happiness[i]-reduction);
        //     reduction++;
        //     if(reduction >= k){
        //         break;
        //     }
        // }
        // return happinessCount;
    }
}
