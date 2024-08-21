class Solution {

    // Method to find the shortest path from a source node to all other nodes in an undirected graph
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create a graph using a HashMap where each node points to a list of its neighbors
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // Populate the graph with the edges
        for (int[] edge : edges) {
            // If the start node of the edge isn't in the graph, add it with an empty list
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<Integer>());
            }
            // Add the end node to the start node's adjacency list
            graph.get(edge[0]).add(edge[1]);

            // Similarly, if the end node isn't in the graph, add it with an empty list
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<Integer>());
            }
            // Add the start node to the end node's adjacency list (since the graph is undirected)
            graph.get(edge[1]).add(edge[0]);
        }

        // Array to store the shortest distance to each node from the source
        int[] ans = new int[n];
        // Array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        // Initialize all distances as -1 (unreachable)
        Arrays.fill(ans, -1);
        // Distance to the source node is 0
        ans[src] = 0;
        visited[src] = true;

        // If the source node has no neighbors, return the result as is
        if (!graph.containsKey(src)) {
            return ans;
        }

        // Queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        // Perform BFS to find the shortest paths
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Get the next node to process
            
            // Traverse all the neighbors of the current node
            for (int neb : graph.get(node)) {
                // If the neighbor hasn't been visited yet
                if (!visited[neb]) {
                    // Update the distance to this neighbor
                    ans[neb] = 1 + ans[node];
                    // Add the neighbor to the queue for further processing
                    queue.offer(neb);
                    // Mark the neighbor as visited
                    visited[neb] = true;
                }
            }
        }
        
        // Return the array of shortest distances
        return ans;
    }
}
