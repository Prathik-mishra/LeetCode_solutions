class Solution {
    private void getCitiesConnectedFilled(int src, int[] noOfCitiesConnected,List<List<Pair>> graph, int threshold){
        int n = graph.size();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.cost,b.cost));
        
        pq.add(new Pair(src,0));
        int[] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src] = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            for(int i=0; i<graph.get(p.node).size(); i++){
                Pair dest = graph.get(p.node).get(i);
                
                if(dist[p.node] + dest.cost < dist[dest.node]){
                    dist[dest.node] = dist[p.node] + dest.cost;
                    pq.add(new Pair(dest.node,dist[dest.node]));
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(dist[i] <= threshold && i != src){
                noOfCitiesConnected[src]++;
            }
        }
        
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] noOfCitiesConnected = new int[n];
        
        List<List<Pair>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int cost = edges[i][2];
            
            graph.get(src).add(new Pair(dest,cost));
            graph.get(dest).add(new Pair(src,cost));
        }
        
        for(int i=0; i<n; i++){
            getCitiesConnectedFilled(i,noOfCitiesConnected,graph,distanceThreshold);
        }
        
        int count = Integer.MAX_VALUE;
        int cityNo = -1;
        
        for(int i=0; i<n; i++){
            if(noOfCitiesConnected[i] <= count){
                count = noOfCitiesConnected[i];
                cityNo = i;
            }
        }
        
        return cityNo;
    }
}

class Pair{
    int node;
    int cost;
    public Pair(int _node, int _cost){
        this.node = _node;
        this.cost = _cost;
    }
}
