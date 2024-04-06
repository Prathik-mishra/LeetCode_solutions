class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int mod = (int)(1e5);
        int[] dist = new int[100000];
        for(int i=0; i<dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start,0));
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            int node = queue.peek().node;
            int steps = queue.peek().steps;
            queue.remove();
            
            if(node == end){
                return steps;
            }
            
            for(int ele : arr){
                int adjNode = (node * ele)%mod;
                
                if(steps + 1 < dist[adjNode]){
                    dist[adjNode] = steps + 1;
                    queue.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        return -1;
    }
}

class Pair{
    int node;
    int steps;
    public Pair(int x,int y){
        this.node = x;
        this.steps = y;
    }
}
