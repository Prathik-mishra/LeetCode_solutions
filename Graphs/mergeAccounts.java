class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU ds = new DSU(n);
        HashMap<String,Integer> hmap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!hmap.containsKey(mail)){
                    hmap.put(mail,i);
                }else{
                    ds.unionBySize(i,hmap.get(mail));
                }        
            }
        }
        
        ArrayList<String>[] mergedMails = new ArrayList[n];
        for(int i=0; i<n; i++){
            mergedMails[i] = new ArrayList<String>();
        }
        
        for(String key : hmap.keySet()){
            int node = hmap.get(key);
            mergedMails[ds.findUParent(node)].add(key);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergedMails[i].size() == 0) continue;
            List<String> lis = mergedMails[i];
            List<String> newLis = new ArrayList<>();
            Collections.sort(lis);
            newLis.add(accounts.get(i).get(0));
            for(String mails : lis){
                newLis.add(mails);
            }
            ans.add(newLis);
        }
        return ans;
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
