import java.util.Scanner;

public class GcdAndLcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        //store the copies of original values:  
        int on1 = n1;
        int on2 = n2;

        
        int recurgcd = gcd(n1,n2);
        
        //to find gcd we have two ways one is itterative and another is recursive:
        while(n1 % n2 != 0){
            int rem = n1%n2;
            n1 = n2;
            n2 = rem;
        }

        // we have out gcd in n2:
        int gcd = n2;
        int lcm = (on1 * on2)/gcd;

        System.out.println(gcd);
        System.out.println(lcm);
        System.out.println(recurgcd);
    }

    private static int gcd(int n1, int n2){
        if(n2 == 0) return n1;
        return gcd(n2 ,n1 % n2);
    }
}
