class Solution {
    public int minimumPushes(String word) {
        //approach using hashmap and priorityQueue :- TC :- O(N)
        int n = word.length();

        HashMap<Character,Integer> hmap = new HashMap<>();

        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }
        
        // PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> -Integer.compare(x.freq,y.freq));

        // for(char key : hmap.keySet()){
        //     pq.add(new Pair(key,hmap.get(key)));
        // }

        // int minPushesh = 0;
        // for(int i=1; i<=4; i++){
        //     for(int j=2; j<=9; j++){
        //         if(pq.isEmpty()) break;
        //         minPushesh += (i * pq.remove().freq);  
        //     }
        //     if(pq.isEmpty()) break;
        // }

        // return minPushesh;

        //further improvision for the solution since the character doesnt matters we use pq of int
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> -Integer.compare(x,y));
        pq.addAll(hmap.values());

        int minPushesh = 0;
        int turn = 1;

        while(!pq.isEmpty()){
            for(int i=1; i<=8; i++){
                if(!pq.isEmpty()){
                    minPushesh += (turn * pq.remove());
                }
            }
            turn++;
        }

        return minPushesh;

    }
}

class Pair{
    char ch;
    int freq;
    public Pair(char _ch,int _freq){
        this.ch = _ch;
        this.freq = _freq;
    }
}
