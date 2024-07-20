import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] bridges = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bridges[i][0] = Integer.parseInt(st.nextToken());
            bridges[i][1] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution();
        System.out.println(s.maxPossibleBridges(bridges));
    }
}

class Solution {
    public int maxPossibleBridges(int[][] bridges) {
        Arrays.sort(bridges,(a,b) -> Integer.compare(a[0],b[0]));

        TreeSet<Integer> tset = new TreeSet<>();
        for(int i=0; i<bridges.length; i++){
            int top = bridges[i][1];
            Integer ceilVal = tset.ceiling(top);
            if(ceilVal != null) tset.remove(ceilVal);
            tset.add(top);
        }

        return tset.size();
    }
}
