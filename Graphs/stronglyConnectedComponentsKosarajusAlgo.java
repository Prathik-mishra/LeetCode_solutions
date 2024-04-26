class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //step 1 : get the ordering in finsishing timing:
        int[] visit = new int[V];
        Stack<Integer> order = new Stack<>();
        for(int i=0; i<V; i++){
            if(visit[i] == 0){
                dfs(adj,order,i,visit);
            }
        }
        
        //step 2: reverse the edges of the graph:
        ArrayList<ArrayList<Integer>> adjNew = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjNew.add(new ArrayList<>());
        }
        
        
        for(int i=0; i<V; i++){
            visit[i] = 0;
            for(int node : adj.get(i)){
                adjNew.get(node).add(i);
            }
        }
        
        int connectedComp = 0;
        while(!order.isEmpty()){
            int node = order.pop();
            if(visit[node] == 0){
                dfs3(adjNew,node,visit);
                connectedComp++;
            }
        }
        
        return connectedComp;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int node,int[] visit){
        visit[node] = 1;
        
        for(int i : adj.get(node)){
            if(visit[i] == 0){
                dfs(adj,st,i,visit);
            }
        }
        st.add(node);
    }
    
    public void dfs3(ArrayList<ArrayList<Integer>> adj,int node,int[] visit){
        visit[node] = 1;
        
        for(int i : adj.get(node)){
            if(visit[i] == 0){
                dfs3(adj,i,visit);
            }
        }
    }
}
