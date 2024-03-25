package HeapDataStructure;
import java.util.*;
class closestPointToOrigin {
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair2> maxHeap = new PriorityQueue<>((x,y) -> -Double.compare(x.diff,y.diff));

        for(int i=0; i<points.length; i++){
            int sum = (int)Math.pow(points[i][0],2) + (int)Math.pow(points[i][1],2);
            double num = (double) Math.sqrt(sum);
            maxHeap.add(new Pair2(num,points[i]));

            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        int[][] ans = new int[maxHeap.size()][2];
        int idx = 0;
        while(maxHeap.size() > 0){
            Pair p = maxHeap.remove();
            ans[idx++] = p.arr;
        }

        return ans;
    }
}
class Pair2{
    double diff;
    int[] arr;
    public Pair2(double x,int[] arr){
        this.diff = x;
        this.arr = arr;
    }
}