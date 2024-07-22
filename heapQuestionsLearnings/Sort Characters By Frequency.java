import java.util.*;

class Solution {
    public String frequencySort(String s) {
        //Write code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.freq == b.freq) return -Character.compare(a.ch,b.ch);
            return -Integer.compare(a.freq,b.freq);
        });

        HashMap<Character,Integer> hmap = new HashMap<>();
        for(char ch : s.toCharArray()){
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }

        for(char key : hmap.keySet()){
            pq.add(new Pair(key,hmap.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int count = p.freq;
            while(count-- > 0){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
    class Pair{
        char ch;
        int freq;
        public Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution Obj = new Solution();
        String result = Obj.frequencySort(s);
        System.out.println(result);
        sc.close();
    }
}
