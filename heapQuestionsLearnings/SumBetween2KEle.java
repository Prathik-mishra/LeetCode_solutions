package HeapDataStructure;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumBetween2KEle{
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        // Your code goes here
        long first = getKthSmallest(A,K1);
        long second = getKthSmallest(A,K2);

        long sum = 0;
        for(long ele : A){
            if(ele > first && ele < second){
                sum += ele;
            }
        }

        return sum;
    }

    public static long getKthSmallest(long[] A,long k){
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(long ele : A){
            maxHeap.add(ele);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        return maxHeap.peek();
    }
}
