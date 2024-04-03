class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            hmap.put(t.charAt(i),hmap.getOrDefault(t.charAt(i),0)+1);
        }
        
        int l=0,r=0,minLen=Integer.MAX_VALUE,count=0,idx=-1;
        while(r<s.length()){
            char ch = s.charAt(r);
                   
            if(hmap.containsKey(ch) && hmap.get(ch) > 0){      
                hmap.put(ch,hmap.getOrDefault(ch,0)-1);
                count++;
            }else{
                hmap.put(ch,hmap.getOrDefault(ch,0)-1);
            }
            
                 
            while(l <= r && count == t.length()){
                char c = s.charAt(l);
                hmap.put(c,hmap.getOrDefault(c,0)+1);
                if(hmap.get(c) > 0){
                    count--;
                }
                if(minLen > (r-l+1)){
                    minLen = (r-l+1);
                    idx = l;
                }
                l++;
            }
            r++;
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(idx,idx+minLen);
    }
}
