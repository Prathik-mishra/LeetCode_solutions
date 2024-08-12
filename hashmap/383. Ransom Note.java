class Solution {
    public boolean canConstruct(String randomNote, String magazine) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int n = randomNote.length(), m = magazine.length();

        for(int i=0; i<m; i++){
            hmap.put(magazine.charAt(i),hmap.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int i=0; i<n; i++){
            char ch = randomNote.charAt(i);

            if(hmap.containsKey(ch)){
                if(hmap.get(ch) <= 0){
                    return false;
                }else{
                    hmap.put(ch,hmap.getOrDefault(ch,0)-1);
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
