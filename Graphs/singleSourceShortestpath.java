public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int dist[] = new int[n];
        for(int i=0; i<n; i++) dist[i] = (int)(1e9);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0;   //since from node to itself is 0

        while(!queue.isEmpty()){
            int node = queue.remove();

            for(int i : adjList.get(node)){
                if(dist[node] + 1 < dist[i]){
                    dist[i] = dist[node]+1;
                    queue.add(i);
                }
            }
        }

        for(int i=0; i<n; i++){
            if(dist[i] == (int)(1e9)){
                dist[i] = -1;  //since that node is unreachable from src node
            }
        }

        return dist;
    }
}
