/* class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length; 

        HashMap<Integer,int[]> map = new HashMap<>();

        int rowIdx = mat.length;
        int colIdx = mat[0].length;

        for(int i=0; i<rowIdx; i++){
            for(int j=0; j<colIdx; j++){
                map.put(mat[i][j], new int[2]);
                map.get(mat[i][j])[0] = i;
                map.get(mat[i][j])[1] = j;
            }
        }
        
        boolean[][] visited = new boolean[rowIdx][colIdx];

        for(int i=0; i<n; i++){
            int num = arr[i];
            int getRowIdx = map.get(num)[0];
            int getColIdx = map.get(num)[1];
            visited[getRowIdx][getColIdx] = true;
            if(checkRow(visited,getRowIdx) || checkCol(visited,getColIdx)){
                return i;
            }
        }

        return 0;
    }
 
    private boolean checkRow(boolean[][] visited, int row){
        int n = visited[0].length;
        int count = 0;

        for(int i=0; i<n; i++){
            if(visited[row][i] == true){
                count++;
            }
        }

        if(count == n){
            return true;
        }

        return false;
    }

    private boolean checkCol(boolean[][] visited, int col){
        int n = visited.length;
        int count = 0;

        for(int i=0; i<n; i++){
            if(visited[i][col] == true){
                count++;
            }
        }

        if(count == n){
            return true;
        }

        return false;
    }
}

*/

/*
class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int numRows = mat.length, numCols = mat[0].length;
        Map<Integer, Pair<Integer, Integer>> numToPos = new HashMap<>();
        // Populate the numToPos map by iterating over the matrix
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int value = mat[row][col];
                numToPos.put(value, new Pair(row, col));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            Pair<Integer, Integer> pos = numToPos.get(num);
            int row = pos.getKey();
            int col = pos.getValue();
            mat[row][col] = -mat[row][col]; // mark as seen

            // Check if the row or column is completely painted
            if (checkRow(row, mat) || checkColumn(col, mat)) {
                return i;
            }
        }

        return -1; // This line will never be reached as per the problem statement
    }

    private boolean checkRow(int row, int[][] mat) {
        // Return true if row is completely seen
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int[][] mat) {
        // Return true if col is completely seen
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }
}

*/

//reverse mapping approach: 
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<len; i++){
            map.put(arr[i],i);
        }

        int n = mat.length;
        int m = mat[0].length;
        int globalMin = len+1;

        //checking all the rows: 
        for(int i=0; i<n; i++){
            int localMax = -1;
            for(int j=0; j<m; j++){
                localMax = Math.max(map.get(mat[i][j]),localMax);
            }

            globalMin = Math.min(localMax, globalMin);
        }


        //checking all the Cols: 
        for(int i=0; i<m; i++){
            int localMax = -1;
            for(int j=0; j<n; j++){
                localMax = Math.max(map.get(mat[j][i]),localMax);
            }

            globalMin = Math.min(localMax, globalMin);
        }

        return globalMin;
    }
}

