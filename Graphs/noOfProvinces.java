class Solution {
    public static class Edge{
        int src;
        int dest;
    
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] visit){
        visit[curr] = true;
        for(int i=0;i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(visit[e.dest] == false){
                dfs(graph,e.dest,visit);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        ArrayList<Edge> graph[] = new ArrayList[n];
        
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    graph[i].add(new Edge(i,j));
                }   
            }
        }
        
        boolean[] visit = new boolean[n];
        int province = 0;
        for(int i=0; i<n; i++){
            if(visit[i] == false){
                province++;
                dfs(graph,i,visit);
            }
        }
        
        return province;
    }
}