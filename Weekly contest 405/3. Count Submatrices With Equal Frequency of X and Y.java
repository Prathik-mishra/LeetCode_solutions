class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Pair[][] prefix = new Pair[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int sum = 0;
                boolean flag = false;
                
                //set the value 
                int val = 0;
                if(grid[i][j] == 'X'){
                    flag = true;
                    val = 1;
                }else if(grid[i][j] == 'Y'){
                    val = -1;
                }
                
                if(flag == true){
                    if(i == 0 && j==0){
                        sum = val;
                    }else if(i==0){
                        sum = val + prefix[i][j-1].data;
                    }else if(j==0){
                        sum = val + prefix[i-1][j].data;
                    }else{
                        sum = val + prefix[i][j-1].data + prefix[i-1][j].data - prefix[i-1][j-1].data;
                    }
                }else{
                    if(i == 0 && j==0){
                        sum = val;
                    }else if(i==0){
                        if(prefix[i][j-1].XPresent == true){
                            flag = true;
                        }
                        sum = val + prefix[i][j-1].data;
                    }else if(j==0){
                        if(prefix[i-1][j].XPresent == true){
                            flag = true;
                        }
                        sum = val + prefix[i-1][j].data;
                    }else{
                        if(prefix[i][j-1].XPresent == true || prefix[i-1][j].XPresent == true){
                            flag = true;
                        }
                        sum = val + prefix[i][j-1].data + prefix[i-1][j].data - prefix[i-1][j-1].data;
                    }
                }
                
                prefix[i][j] = new Pair(sum,flag);
            }
        }
        
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(prefix[i][j].XPresent == true && prefix[i][j].data == 0){
                    count++;
                }
            }
        }
        
        return count;
    }
}

class Pair{
    int data;
    boolean XPresent;
    public Pair(int x,boolean y){
        this.data = x;
        this.XPresent = y;
    }
}
