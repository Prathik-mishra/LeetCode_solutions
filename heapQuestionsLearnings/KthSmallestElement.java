package HeapDataStructure;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int ele : arr){
            maxHeap.add(ele);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        return maxHeap.peek();
    }
}
