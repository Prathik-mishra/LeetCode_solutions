class Solution {
    public int countGoodNodes(int[][] edges) {
        int n = edges.length+1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        int[] count = new int[n];
        dfs(0,-1,count,graph);
        int goodNodeCount = 0;
        
        for(int i=0; i<n; i++){
            int prevsubTreeNodeSize = -1; 
            boolean flag = true;
            for(int nbr : graph.get(i)){
                if(count[nbr] < count[i]){
                    if(prevsubTreeNodeSize == -1){
                        prevsubTreeNodeSize = count[nbr];
                    }else if(prevsubTreeNodeSize != count[nbr]){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                goodNodeCount++;
            }
        }
        return goodNodeCount;
    }

    private int dfs(int node,int parent,int[] count, ArrayList<ArrayList<Integer>> graph){
        int size = 1;   //at initialy its size is 1;
        for(int nbr : graph.get(node)){
            if(nbr != parent){
                size += dfs(nbr,node,count,graph);
            }
        }
        count[node] = size;
        return size;
    }
}
