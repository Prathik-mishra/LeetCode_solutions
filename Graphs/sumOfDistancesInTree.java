class Solution {
    static int[] ans;
    static int[] count;
    static int N;
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> graph,int parent){
        for(int child : graph.get(node)){
            if(child != parent){
                dfs(child,graph,node);
                count[node] += count[child]; 
                ans[node] += ans[child] + count[child];
            }
        }
    }
    
    public void dfs2(int node,ArrayList<ArrayList<Integer>> graph,int parent){
        for(int child : graph.get(node)){
            if(child != parent){
                ans[child] = ans[node] - count[child] + (N - count[child]);
                dfs2(child,graph,node);
            }
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        ans = new int[n];
        count = new int[n];
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
            count[i] = 1;
        }
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        dfs(0,graph,-1);
        dfs2(0,graph,-1);
        
        return ans;
    }
}
