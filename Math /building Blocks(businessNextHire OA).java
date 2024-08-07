import java.util.Scanner;

public class EqualBlocksInPiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        System.out.println(findMinPiles(A));
    }

    public static int findMinPiles(int[] A) {
        int gcdValue = A[0];
        
        // Calculate GCD of all elements
        for (int i = 1; i < A.length; i++) {
            gcdValue = gcd(gcdValue, A[i]);
        }
        
        int totalPiles = 0;
        
        // Calculate total number of new piles
        for (int blocks : A) {
            totalPiles += blocks / gcdValue;
        }
        
        return totalPiles;
    }

    // Helper function to calculate GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
