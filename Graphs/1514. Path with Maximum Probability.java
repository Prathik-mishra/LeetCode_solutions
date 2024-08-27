class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        //Bellmenford algorithm: 
        double[] maxProb = new double[n];
        maxProb[start_node] = 1; //since prob of reaching from start is always 1 

        for(int i=0; i<n; i++){
            int j = 0;
            boolean isItterated = false;
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                double pathProb = succProb[j];
                j++;

                if(maxProb[u] * pathProb > maxProb[v]){
                    maxProb[v] = maxProb[u] * pathProb;
                    isItterated = true;
                }

                if(maxProb[v] * pathProb > maxProb[u]){
                    maxProb[u] = maxProb[v] * pathProb;
                    isItterated = true;
                }
            }

            if(!isItterated){  // this is to optimise the approach: 
                break; 
            }
        }

        return maxProb[end_node];
    }
}
