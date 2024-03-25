package HeapDataStructure;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortAKSortedArray {
    public static ArrayList<Integer> nearlySorted(int[] arr,int k,int num){
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<num; i++){

            minHeap.add(arr[i]);

            if(minHeap.size() > k){
                list.add(minHeap.remove());
            }
        }

        while(minHeap.size() > 0){
            list.add(minHeap.remove());
        }

        return list;
    }
}
