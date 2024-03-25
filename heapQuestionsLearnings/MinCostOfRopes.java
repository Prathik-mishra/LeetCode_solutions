package HeapDataStructure;

import java.util.PriorityQueue;

public class MinCostOfRopes {
    public static long minCost(long arr[], int n)
    {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }

        long cost = 0;
        while(pq.size() > 1){
            long first = pq.remove();
            long second = pq.remove();

            long mergedLen = first + second;
            pq.add(mergedLen);
            cost += mergedLen;
        }
        return cost;
    }
}
