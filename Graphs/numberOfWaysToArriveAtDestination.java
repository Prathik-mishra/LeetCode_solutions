class Solution {
     
    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.size(); i++){
            int src = roads.get(i).get(0);
            int dest = roads.get(i).get(1);
            int wt = roads.get(i).get(2);
            graph.get(src).add(new Pair(dest,wt));
            graph.get(dest).add(new Pair(src,wt));
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Long.compare(a.wt,b.wt));
        
        int[] ways = new int[n];
        long[] dist = new long[n];
        
        for(int i=0; i<n; i++) {
            dist[i] = (int)(1e18);
            ways[i] = 0;
        }
        
        ways[0] = 1;
        dist[0] = 0;
        queue.add(new Pair(0,0));
        
        int mod = (int)(1e9+7); 
        
        while(!queue.isEmpty()){
            int node = queue.peek().node;
            long wt = queue.peek().wt;
            queue.remove();
            
            for(Pair it : graph.get(node)){
                int adjNode = it.node;
                long adjW = it.wt;
                
                if(adjW + wt < dist[adjNode]){
                    dist[adjNode] = wt + adjW;
                    ways[adjNode] = ways[node];
                    queue.add(new Pair(adjNode,adjW+wt));
                }else if(wt + adjW == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}

class Pair{
    int node;
    long wt;
    public Pair(int node,long wt){
        this.node = node;
        this.wt = wt;
    }
}