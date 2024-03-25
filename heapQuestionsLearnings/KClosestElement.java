package HeapDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElement {
    public static ArrayList<Integer> kclosestEle(int[] arr, int k, int x){
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> a.absDiff == b.absDiff ? -Integer.compare(a.element,b.element) : -Integer.compare(a.absDiff,b.absDiff));

        for(int ele : arr){
            maxHeap.add(new Pair(ele,Math.abs(x-ele)));

            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        while(maxHeap.size() > 0){
            Pair p = maxHeap.remove();
            list.add(p.element);
        }

        Collections.sort(list);
        return list;
    }
}
class Pair{
    int element;
    int absDiff;
    public Pair(int x,int y){
        this.element = x;
        this.absDiff = y;
    }
}