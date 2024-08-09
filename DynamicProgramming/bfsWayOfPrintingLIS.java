import java.util.*;
public class Main{
    public static class Pair{
        int idx;
        String psf;
        Pair(int x,String str){
            this.idx = x;
            this.psf = str;
        }
    }
    public static void solution(int []arr){

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int max = 0;
        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(arr[i] >= arr[prev] && dp[prev]+1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                }
            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
        
        Queue<Pair> queue = new LinkedList<>();
        for(int i=n-1; i>=0; i--){
            if(dp[i] == max){
                queue.add(new Pair(i,arr[i]+" "));
            }
        }

        ArrayList<String> list = new ArrayList<>();
        
        while(!queue.isEmpty()){
            Pair p = queue.remove();

            int idx = p.idx;
            String psf = p.psf;

            if(dp[idx] == 1){
                list.add(psf);
                continue;
            }
            
            for(int i=idx-1; i>=0; i--){
                if(arr[i] <= arr[idx] && dp[idx]-1 == dp[i]){
                    queue.add(new Pair(i,arr[i]+" "+psf));
                }
            }
        }

        Collections.sort(list);
        for(String i : list){
            System.out.println(i);
        }
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
