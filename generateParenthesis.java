class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTracking(list,"",0,0,n);
        return list;
    }
    
    public void backTracking(List<String> list, String str,int O,int C,int n){
        if(str.length() == n * 2){
            list.add(str);
            return;
        }
        
        if(O < n) backTracking(list,str+'(',O+1,C,n);
        if(C < O) backTracking(list,str+')',O,C+1,n);
    }
}