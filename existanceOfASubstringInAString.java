class Solution {
    public boolean isSubstringPresent(String s) {
        String revStr = reverse(s);
        
        for(int i = 0; i < s.length()-1; i++){
            if(revStr.contains(s.substring(i,i+2))){
                return true;
            }
        }
        return false;
    }
    
    public String reverse(String s){
          
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}