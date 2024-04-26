class Solution {
    public boolean isValidCell(int row,int col,int n){
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    public int largestIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        
        
        int node = n*n;
        DSU ds = new DSU(node);
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        //step 1: make connections by unionfind ds
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    for(int dir=0; dir<4; dir++){
                        int adjI = i + dx[dir];
                        int adjJ = j + dy[dir];
                        if(isValidCell(adjI,adjJ,n) && grid[adjI][adjJ] == 1){
                            int u = (i * n) + j;
                            int v = (adjI * n) + adjJ;
                            ds.unionBySize(u,v);
                        }
                    }
                }
            }
        }
        
        //step 2: get the larger ans by making ans:
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int dir=0; dir<4; dir++){
                        int adjI = i + dx[dir];
                        int adjJ = j + dy[dir];
                        if(isValidCell(adjI,adjJ,n) && grid[adjI][adjJ] == 1){
                            int u = (adjI * n) + adjJ;
                            int ulp = ds.findUParent(u);
                            int size = ds.size[ulp];
                            set.add(ulp);
                        }
                    }
                    
                    int currSum = 1;
                    for(int adj : set){
                        currSum += ds.size[adj];
                    }
                    
                    ans = Math.max(currSum,ans);
                }
            }
        }
        
        //set 3: if there is no zero or we have some cell with most number of size:
        // for(int cell=0; cell<n*n; cell++){
        //     ans = Math.max(ans,ds.size[ds.findUParent(cell)]);
        // }
        
        return ans == 0 ? n*n : ans;
    }
}

class DSU{
    int[] size;
    int[] parent;
    public DSU(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    
    public int findUParent(int node){
        if(parent[node] == node){
            return node;
        }
        
        return parent[node] = findUParent(parent[node]);
    }
    
    public void unionBySize(int u,int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        
        if(ulp_u == ulp_v) return;
        
        if(size[ulp_u] >= size[ulp_v]){
            size[ulp_u] += size[ulp_v];
            parent[ulp_v] = ulp_u;
        }else{
            size[ulp_v] += size[ulp_u];
            parent[ulp_u] = ulp_v;
        }
    }
}
