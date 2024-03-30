class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] localvis = new boolean[V];
        boolean[] globalvis = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(globalvis[i] == false){
                if(dfs(i,adj,localvis,globalvis) == true){
                    return true;
                }   
            }
        }
        
        return false;
    }
    
    public boolean dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean[] globalvis,boolean[] localvis){
        localvis[src] = true;
        globalvis[src] = true;
        
        for(int i : adj.get(src)){
            if(globalvis[i] == false){
                if(dfs(i,adj,globalvis,localvis) == true){
                    return true;
                }
            }else if(localvis[i] == true){
                return true;
            }
        }
        
        localvis[src] = false;
        return false;
    }
}
