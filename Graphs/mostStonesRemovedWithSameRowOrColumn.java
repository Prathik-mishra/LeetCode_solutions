class Solution {
    public int removeStones(int[][] stones) {
        int row = 0;
        int col = 0;
        int n = stones.length;
        //since the grid length is not given we first find the lenght of row and grid:
        //note the row and col will be 0 indexed since we are getting from the coordinate points by exploring the max boundary of row and col in entire stones arr given to us
        
        for(int[] arr : stones){
            row = Math.max(arr[0],row);
            col = Math.max(arr[1],col);
        }
        
        int nodes = row + col + 1;
        DSU ds = new DSU(nodes);
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            int u =  stones[i][0];
            int v =  stones[i][1] + row + 1;
            ds.unionBySize(u,v);
            set.add(u);
            set.add(v);
        }
        
        //we have to find the number of components we can make:
        int cnt = 0;
        for(int node : set){
            if(ds.findUParent(node) == node){
                cnt++;
            }
        }
        
        return n - cnt; 
    }
}

class DSU{
    int[] size;
    int[] parent;

    public DSU(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUParent(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = findUParent(parent[u]);
    }

    public void unionBySize(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v){   //same component so just return
            return;
        }

        if(size[ulp_u] > size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }

}
