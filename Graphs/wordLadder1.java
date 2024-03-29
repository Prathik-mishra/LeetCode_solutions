class Solution {
    class Pair{
        String first;
        int second;
        public Pair(String f,int s){
            this.first = f;
            this.second = s;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hset = new HashSet<>();
        q.offer(new Pair(beginWord,1));
        
        for(String str : wordList){
            hset.add(str);
        }
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            String s = p.first;
            int steps = p.second;
            if(s.equals(endWord)) return steps;
            for(int i=0; i<s.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char convertToCharArr[] = s.toCharArray();
                    convertToCharArr[i] = ch;
                    String string = new String(convertToCharArr);
                    if(hset.contains(string)){
                        hset.remove(string);
                        q.offer(new Pair(string,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}