class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> -Integer.compare(x.freq,y.freq));

        if(a > 0) pq.add(new Pair(a,'a'));
        if(b > 0) pq.add(new Pair(b,'b'));
        if(c > 0) pq.add(new Pair(c,'c'));

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int freq = p.freq;
            char ch = p.ch;

            if(sb.length() >= 2 && sb.charAt(sb.length()-2) == ch && sb.charAt(sb.length()-1) == ch){
                
                if(pq.isEmpty()) break;

                Pair newP = pq.remove();
                int newFreq = newP.freq;
                char newCh = newP.ch;
                sb.append(newCh);
                newFreq--; 

                if(newFreq > 0){
                    pq.add(new Pair(newFreq,newCh));
                }
                pq.add(new Pair(freq,ch));
            }else{
                sb.append(ch);
                freq--;
                if(freq > 0){
                    pq.add(new Pair(freq,ch));
                }     
            }
        }

        return sb.toString();
    }
}

class Pair{
    int freq;
    char ch;
    public Pair(int freq, char ch){
        this.freq = freq;
        this.ch = ch;
    }
}
