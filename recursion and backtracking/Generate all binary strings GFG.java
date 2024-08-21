class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
        List<String> list = new ArrayList<>();
        backTrack(n,"",list);
        return list;
  }
  private static void backTrack(int n, String str, List<String> list){
        if(n == 0){
            list.add(str);
            return;
        }
        
        backTrack(n-1,str+"0",list);
        
        if(str.length() == 0 || str.charAt(str.length()-1) != '1'){
            backTrack(n-1,str+"1",list);
        }
        
        
    }
}
