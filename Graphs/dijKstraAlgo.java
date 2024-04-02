class Solution
{ 
    //custom pair class for storing the node and distance in (pq) MinHeap ds
    static class Pair{
        int node;
        int distance;
        
        Pair(int x,int y){
            this.node = x;
            this.distance = y;
        }
    }
    
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.       //V is vertex and S is source from where we need to start
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.distance - b.distance);
        
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[S] = 0;  //since the place from where we start has zero distance from itself
        
        pq.add(new Pair(S,0));
        
        while(pq.size() != 0){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            
            for(int i=0; i<adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;
    }
}
