class Solution {
    static int solve(int bt[] ) {
        // code here
        Arrays.sort(bt);
        int watingTime = bt[0], sum = 0;
        
        for(int i=1; i<bt.length; i++){
            sum += watingTime;
            watingTime += bt[i];
        }
        
        return (int) sum/bt.length;
  }
}
