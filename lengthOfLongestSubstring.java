class Solution {
    public int lengthOfLongestSubstring(String s) {
        //approach 1: generate all the subStrings and get the largest distinct substring and use a hashset to chech the distinct character T.C : O(n^3) S.C :- O(n)
        //--> we can directly jump to another solutions case it will exceed the TL and through the error and hence it is also too much intutive to think 
        
        //approach 2: using a hashset T.C :- O(2*n) and S.C :- O(n)
        // HashSet<Character> hset = new HashSet();
        // int i = 0,j = 0;
        // int maxLen = 0;
        // int n = s.length();
        // while(j<n){
        //     char ch = s.charAt(j);
        //     if(hset.contains(ch) == false){
        //         hset.add(ch);
        //     }else{
        //         while(hset.contains(ch)){
        //             hset.remove(s.charAt(i));
        //             i++;
        //         }
        //         hset.add(ch);  
        //     }
        //     maxLen = Math.max(maxLen,(j-i)+1);
        //     j++;
        // }
        // return maxLen;
        
        //approach 3: using a hashmap and two pointer sliding window approach T.C:- O(n) and S.C:- O(n) this is the optimal solution but not much intutive to think
        HashMap<Character, Integer> hmap = new HashMap<>();
        int i=0,j=0;
        int n=s.length();
        int maxLen = 0;
        while(j<n){
            char ch = s.charAt(j);
            if(hmap.containsKey(ch)){
                i = Math.max(hmap.get(ch)+1,i);
            }
            
            hmap.put(ch,j);
            maxLen = Math.max(maxLen,(j-i)+1);
            j++;
        }
        return maxLen;
    }
}