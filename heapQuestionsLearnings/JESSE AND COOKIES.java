import java.util.*;
import java.io.*;

class Solution{
    static int solve(int a[],int n,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int steps = 0;
        
        for(int i : a){
            pq.add(i);
        }
        
        while(!pq.isEmpty() && pq.peek() < k){
            int val1 = 1 * pq.remove();
            int val2 = 2 * pq.remove();
            pq.add(val1 + val2);
            steps++;
        }
        return steps;
    }
}
public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }   
        System.out.println(Solution.solve(a,n,k));
    }
}
