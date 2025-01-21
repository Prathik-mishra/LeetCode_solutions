// was not able to cover the corner cases: ex :- [[20,3,20,17,2,12,15,17,4,15],[20,10,13,14,15,5,2,3,14,3]]
/*
class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        int[][] junctionMat = new int[2][n];

        // building prefix suffix junction matrix: 
        int prefixSum = 0;
        int suffixSum = 0;

        for(int i=0; i<n; i++){
            prefixSum += grid[0][i];
            suffixSum += grid[1][n-i-1];

            junctionMat[0][i] = prefixSum;
            junctionMat[1][n-i-1] = suffixSum;
        }

        int junctionIdx = -1;
        int maxJunction = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(maxJunction < junctionMat[0][i] + junctionMat[1][i]){
                maxJunction = junctionMat[0][i] + junctionMat[1][i];
                junctionIdx = i;
            }
        }

        // make the original grid zero from junctionIdx left and rightwords 
        // left words 
        for(int i=junctionIdx; i>=0; i--){
            grid[0][i] = 0;
        }

        for(int i=junctionIdx; i<n; i++){
            grid[1][i] = 0;
        }

        // building prefix suffix junction matrix: 
        prefixSum = 0;
        suffixSum = 0;

        for(int i=0; i<n; i++){
            prefixSum += grid[0][i];
            suffixSum += grid[1][n-i-1];

            junctionMat[0][i] = prefixSum;
            junctionMat[1][n-i-1] = suffixSum;
        }

        maxJunction = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(maxJunction < junctionMat[0][i] + junctionMat[1][i]){
                maxJunction = junctionMat[0][i] + junctionMat[1][i];
            }
        }

        return maxJunction;
    }
}
*/

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] junctionMat = new long[2][n];

        // building prefix suffix junction matrix: 
        long prefixSum = 0;
        long suffixSum = 0;

        for(int i=0; i<n; i++){
            prefixSum += grid[0][i];
            suffixSum += grid[1][n-i-1];

            junctionMat[0][i] = prefixSum;
            junctionMat[1][n-i-1] = suffixSum;
        }


        long minAns = Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            Long left = (long) 0, right = (long) 0;
            if(i != 0){
                left = junctionMat[1][0] - junctionMat[1][i];
            }
            if(i != n-1){
                right = junctionMat[0][n-1] - junctionMat[0][i];
            }

            Long max = Math.max(left,right);
            minAns = Math.min(minAns,max);
        }

        return minAns;
    }
}
