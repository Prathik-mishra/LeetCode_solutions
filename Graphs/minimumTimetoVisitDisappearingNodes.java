class Solution {
    class Pair{
        int node;
        int timeToReach;
        
        Pair(int node, int timeToReach){
            this.node = node;
            this.timeToReach = timeToReach;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<Pair>> graph = new ArrayList<>();
        int ans[] = new int[n];
        boolean visited[] = new boolean[n];

        Arrays.fill(ans,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            return a.timeToReach - b.timeToReach;
        });
        
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < edges.length ; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int time = edges[i][2];
            
            graph.get(src).add(new Pair(dest,time));
            graph.get(dest).add(new Pair(src,time));
        }
        
        pq.add(new Pair(0,0));
        ans[0] = 0;
        
        while(pq.size() > 0){
            Pair pair = pq.remove();
            
            if(visited[pair.node] || pair.timeToReach >= disappear[pair.node]){
                continue;
            }

            visited[pair.node] = true;
            for(Pair neigh : graph.get(pair.node)){
                int takenTime = pair.timeToReach + neigh.timeToReach;

                if(ans[neigh.node] > takenTime && takenTime < disappear[neigh.node] && !visited[neigh.node]){
                    ans[neigh.node] = takenTime;
                    pq.add(new Pair(neigh.node,takenTime));
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            if(ans[i] == Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}
