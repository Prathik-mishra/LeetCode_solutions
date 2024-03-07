class Solution {
    public static List<Integer> getRow(int row){
        int res = 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(res);
        for(int col = 1 ; col < row ; col++){
            res = res * (row - col);
            res = res/col;
            ans.add(res);   
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= numRows ; i++){
            result.add(getRow(i));
        }
        return result;
    }
}