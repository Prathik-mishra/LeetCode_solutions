class Solution {
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        backTrack(n,"",list);
        return list;
    }
    
    private void backTrack(int n, String str, List<String> list){
        if(n == 0){
            list.add(str);
            return;
        }
        
        
        if(str.length() == 0 || str.charAt(str.length()-1) != '0'){
            backTrack(n-1,str+"0",list);
        }
        
        backTrack(n-1,str+"1",list);
    }
}
