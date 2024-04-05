class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //creation og graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<flights.length; i++){
            graph.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        //dijkstra's algo starts from here
        Queue<Truple> queue = new LinkedList<>();
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;   //marking source as zero cause the cost is zero
        queue.add(new Truple(0,src,0));
        
        while(!queue.isEmpty()){
            Truple temp = queue.remove();
            int stops = temp.first;
            int node = temp.second;
            int cost = temp.third;
            
            if(stops > k) continue;
            for(Pair i : graph.get(node)){
                int adjNode = i.first;
                int edjW = i.second;
                
                if(cost + edjW < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edjW;
                    queue.add(new Truple(stops+1,adjNode,cost+edjW));
                }
            }
        }
        
        if(dist[dst] == (int)(1e9)) return -1; //since not reachable in k stops
        return dist[dst];
    }
}

class Pair{
    int first;
    int second;
    public Pair(int x,int y){
        this.first = x;
        this.second = y;
    }
}

class Truple{
    int first;
    int second;
    int third;
    public Truple(int x,int y,int z){
        this.first = x;
        this.second = y;
        this.third = z;
    }
}
