class Solution
{
    public ArrayList<Integer> getOrder(ArrayList<ArrayList<Integer>> adjList,int k){
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] degree = new int[k];
        for(int i=0; i<k; i++){
            for(int j : adjList.get(i)){
                degree[j]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<k; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int ele = queue.poll();
            ans.add(ele);
            
            for(int i : adjList.get(ele)){
                degree[i]--;
                if(degree[i] == 0){
                    queue.add(i);
                }
            }
        }
        
        return ans;
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<K; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int n = Math.min(s1.length(),s2.length()),idx = 0;
            while(idx < n){
                if(s1.charAt(idx) != s2.charAt(idx)){
                    adjList.get(s1.charAt(idx) - 'a').add(s2.charAt(idx) - 'a');
                    break;
                }
                idx++;
            }
        }
        
        ArrayList<Integer> ansInt = getOrder(adjList,K);
        String order = "";
        for(int i : ansInt){
            order = order + (char)(i + (int)'a');
        }
        
        return order;
    }
}
