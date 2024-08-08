class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        int[] edgeCount = new int[n];
        for(int i=0; i<roads.length; i++){
            int src = roads[i][0];
            int dest = roads[i][1];

            graph.get(src).add(dest);
            graph.get(dest).add(src);

            edgeCount[src]++;
            edgeCount[dest]++;
        }

        int maxNetworkRank = 0;
        for(int i=0; i<n; i++){
            int maxSum = 0;
            for(int j=0; j<n; j++){
                int sum = 0;
                if(i != j){
                    sum = edgeCount[i]+edgeCount[j];
                    if(isPresent(i,j,graph) == true){
                        sum -= 1;
                    }
                }
                maxSum = Math.max(maxSum,sum);
            }
            maxNetworkRank = Math.max(maxNetworkRank,maxSum);
        }

        return maxNetworkRank;
    }

    private boolean isPresent(int node, int destNode, ArrayList<ArrayList<Integer>> graph){
        for(int i=0; i<graph.get(node).size(); i++){
           if(graph.get(node).get(i) == destNode) return true;
        }
        return false;
    }
}
