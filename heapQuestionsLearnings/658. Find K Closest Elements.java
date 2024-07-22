class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
//         List<Integer> list = new ArrayList<>();
//         PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> a.absDiff == b.absDiff ? -Integer.compare(a.element,b.element) : -Integer.compare(a.absDiff,b.absDiff));
        
//         for(int ele : arr){
//             maxHeap.add(new Pair(ele,Math.abs(x-ele)));
            
//             if(maxHeap.size() > k){
//                 maxHeap.remove();
//             }
//         }
        
//         while(maxHeap.size() > 0){
//             Pair p = maxHeap.remove();
//             list.add(p.element);
//         }
        
//         Collections.sort(list);
//         return list;
        
        int start=0;
		long sum=0;
		long min=(long)1e9;
		int ai=-1,aj=-1;
		for(int i=0;i<arr.length;i++){
			sum+=Math.abs(arr[i]-x);
			while(i-start+1>k){
				sum-=Math.abs(arr[start++]-x);
			}
			if(i-start+1==k && sum<min){
				min=sum;
				ai=start;
				aj=i;
			}
		}
		List<Integer> list= new ArrayList<>();
		for(int i=ai;i<=aj;i++){
			list.add(arr[i]);
		}

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
