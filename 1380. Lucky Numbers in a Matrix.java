class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {/*
        int n = matrix.length, m = matrix[0].length;
        List<Integer> luckyNumList = new ArrayList<>();
        int[] rowMin = new int[n];
        int[] colMax = new int[m];
        
        //building rowMin mat: 
        for(int i=0; i<n; i++){
            int minEle = Integer.MAX_VALUE;
            for(int j=0; j<m; j++){
                minEle = Math.min(minEle,matrix[i][j]);
            }
            rowMin[i] = minEle;
        }
        
        //building colMax mat: 
        for(int j=0; j<m; j++){
            int maxEle = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                maxEle = Math.max(maxEle,matrix[i][j]);
            }
            colMax[j] = maxEle;
        }
        
        //building the ansList: 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(rowMin[i] == colMax[j]){
                    luckyNumList.add(matrix[i][j]);
                }
            }
        }
        
        return luckyNumList;
        */
        //2nd approach : 
        int N = matrix.length, M = matrix[0].length;

        int rMinMax = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int rMin = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                rMin = Math.min(rMin, matrix[i][j]);
            }
            rMinMax = Math.max(rMinMax, rMin);
        }

        int cMaxMin = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            int cMax = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                cMax = Math.max(cMax, matrix[j][i]);
            }
            cMaxMin = Math.min(cMaxMin, cMax);
        }

        if (rMinMax == cMaxMin) {
            return new ArrayList<>(Arrays.asList(rMinMax));
        }

        return new ArrayList<>();
    }
}
