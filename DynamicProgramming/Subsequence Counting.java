import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String p = br.readLine();
        Solution sol = new Solution();
        System.out.println(sol.numberOfOccurrences(s, p));
    }
}

class Solution {
    public int numberOfOccurrences(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1) == p.charAt(j-1))
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 1000000007;
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}
