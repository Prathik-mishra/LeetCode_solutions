class Solution {
    public void dfs(ArrayList<ArrayList<Pair>> adjList,int src,Stack<Integer> st,boolean[] visit){
        visit[src] = true;
        
        for(Pair i : adjList.get(src)){
            Pair p = i;
            int node = p.dest;
            if(visit[node] == false){
                dfs(adjList,node,st,visit);
            }
        }
        
        st.push(src);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		//create a graph:
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
		
		for(int i=0; i<N; i++){
		    adjList.add(new ArrayList<>());
		}
		
		for(int i=0; i<edges.length; i++){
		    adjList.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
        
		//using topo sort first to get the order in which we further will relax the edges:
		Stack<Integer> st = new Stack<>();
		boolean visit[] = new boolean[N];
		
 		for(int i=0; i<N; i++){
 		    if(visit[i] == false){
 		        dfs(adjList,i,st,visit);
 		    }
 		}
 		
 	    int[] dist = new int[N];
 	    Arrays.fill(dist,(int)(1e9));
 	    dist[0] = 0;  //since the distance from the node to itself is zero
 	    
 	    while(!st.isEmpty()){
 	        int node = st.pop();
 	        
 	        for(Pair pair : adjList.get(node)){
 	            Pair p = pair;
 	            int dest = p.dest;
 	            int wt = p.wt;
 	            
 	            if(dist[node] + wt < dist[dest]){
 	                dist[dest] = dist[node] + wt;
 	            }
 	        }
 	    }
 	    
 	    for(int i=0; i<N; i++){
 	        if(dist[i] == (int)(1e9)){
 	            dist[i] = -1;
 	        }
 	    }
 	    return dist;
	}
}

class Pair{
    int dest;
    int wt;
    public Pair(int x,int y){
        this.dest = x;
        this.wt = y;
    }
}
