class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> nodes = new ArrayList<>();
        boolean[] visit = new boolean[V];
        
        
        dfs(adj,0,nodes,visit);
        return nodes;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int curr,ArrayList<Integer> nodes,boolean[] visit){
        visit[curr] = true;
        nodes.add(curr);
        for(int ele : adj.get(curr)){
            if(visit[ele] == false){
                dfs(adj,ele,nodes,visit);
            } 
        }
    }
}