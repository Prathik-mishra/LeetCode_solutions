class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currSum = 0, station = 0, gasWeHave = 0, gasWeNeed = 0;
        for(int i=0; i<n; i++){
            currSum += gas[i];
            currSum -= cost[i];
            if(currSum < 0){
                station = i+1;
                currSum = 0;
            }
            gasWeHave += gas[i];
            gasWeNeed += cost[i];
        }
        
        return gasWeHave >= gasWeNeed ? station : -1;
    }
}
