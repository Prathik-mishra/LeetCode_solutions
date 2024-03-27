class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> nodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[V];
        q.add(0);
        visit[0] = true;
        
        while(!q.isEmpty()){
            int node = q.remove();
            nodes.add(node);
            
            for(int ele : adj.get(node)){
                if(visit[ele] == false){
                    visit[ele] = true;
                    q.offer(ele);
                }
            }
        }
        
        return nodes;
        
    }
}