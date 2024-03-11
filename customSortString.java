class Solution {
    public String customSortString(String order, String s) {
        
        //approach 1: custom sort
        // Create char array for editing
        int N = s.length();
        Character[] result = new Character[N];
        for (int i = 0; i < N; i++) {
            result[i] = s.charAt(i);
        }

        // Define the custom comparator
        Arrays.sort(result, (c1, c2) -> {
            // The index of the character in order determines the value to be sorted by
            return order.indexOf(c1) - order.indexOf(c2);
        });

        // Return the result
        String resultString = "";
        for (Character c: result) {
            resultString += c;
        }
        return resultString;
        
        
        
        //approach 2: using hashmap
        /*
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            //if the character is present in the map then get the freq of it and append it in the stringBuilder sb
            while(hmap.getOrDefault(ch,0) > 0){
                sb.append(ch);
                hmap.put(ch,hmap.get(ch)-1);
            }
        }
        
        //append the remaning characters in the hashmap whose count is greater than 0
        for(char ch : hmap.keySet()){
            int freq = hmap.get(ch);
            while(freq-- > 0){
                sb.append(ch);
            }
        }
        
        return sb.toString();
        */
    }
}