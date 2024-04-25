class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        int n = rows * cols;
        int[][] visit = new int[rows][cols]; 
        DSU ds = new DSU(n);
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        for(int[] arr : operators){
            int row = arr[0];
            int col = arr[1];
            
            //if already visited then just the current count and move for next operation:
            if(visit[row][col] == 1){
                ans.add(cnt);
                continue;
            }
            visit[row][col] = 1;
            cnt++;
            
            //check for all the four directions and connect if not already connected:
            for(int dir=0; dir<4; dir++){
                int adjRow = row + dx[dir];
                int adjCol = col + dy[dir];
                
                //check for valid cell:
                if(isValidCell(adjRow,adjCol,rows,cols)){
                    if(visit[adjRow][adjCol] == 1){
                        //check for the components: 
                        int u = (row * cols) + col;
                        int v = (adjRow * cols) + adjCol;
                        if(ds.findUParent(u) != ds.findUParent(v)){
                            cnt--;
                            ds.unionBySize(u,v);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    
    private boolean isValidCell(int row,int col,int n,int m){
        return row >= 0 && row < n && col >= 0 && col < m;
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
