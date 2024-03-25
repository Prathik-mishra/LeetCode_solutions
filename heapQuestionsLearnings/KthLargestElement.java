package HeapDataStructure;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int kthLargestElement(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int element : arr){
            minHeap.add(element);
            if(minHeap.size() > k){
               minHeap.remove();
            }
        }
        return minHeap.remove();
    }
}
