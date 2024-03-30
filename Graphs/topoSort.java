//the code has both bfs and dfs traversal in the method define the question is present in GFG
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static void dfs(int src,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] vis){
        vis[src] = true;
        
        for(int i : adj.get(src)){
            if(vis[i] == false){
                dfs(i,adj,st,vis);
            }
        }
        
        st.push(src);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // this is for topo sort is using dfs
        /*
        boolean[] vis = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                dfs(i,adj,st,vis);
            }
        }
        
        int[] ans = new int[V];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        
        return ans;
        */
        
        //the below code is for topo sort using bfs AKA kahn's algorithm:
        int[] ans = new int[V];
        int[] degree = new int[V];

        for(int i=0; i<V; i++){
            for(int x : adj.get(i)){
                degree[x]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        
        int idx = 0;
        while(!queue.isEmpty()){
            int ele = queue.remove();
            ans[idx++] = ele;
            
            for(int x : adj.get(ele)){
                degree[x]--;
                if(degree[x] == 0){
                    queue.add(x);
                }
            }
        }
        
        return ans;
    }
}