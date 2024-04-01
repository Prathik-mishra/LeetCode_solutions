//to solve this we reverse all the edges in the graph given
        //and while traversal if any node gets indegree zero we add it
        //it can be solved using both topo sort bfs and dfs
        //in bfs we use kahn's algo and dfs we use cycle detection of DG
        class Solution {
            public List<Integer> eventualSafeNodes(int[][] graph) {
                int n = graph.length;
                List<Integer> ans = new ArrayList<>();
                
                ArrayList<ArrayList<Integer>> newgraph = new ArrayList<>();
                
                for(int i=0; i<n; i++){
                    newgraph.add(new ArrayList<>());
                }
                
                int[] degree = new int[n];
                for(int i=0; i<n; i++){
                    for(int node : graph[i]){
                        degree[i]++;
                        newgraph.get(node).add(i);
                    }
                }
                
               //Kahn's algo:
                Queue<Integer> queue = new LinkedList<>();
                
                for(int i=0; i<n; i++){
                    if(degree[i] == 0){
                        queue.add(i);
                    }
                }
                
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    ans.add(node);
                    
                    for(int i : newgraph.get(node)){
                        degree[i]--;
                        if(degree[i] == 0){
                            queue.add(i);
                        }
                    }
                }
                
                Collections.sort(ans);
                return ans;
            }
        }
