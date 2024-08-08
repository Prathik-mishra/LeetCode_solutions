
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
    public static int fun(String s)
    {
        //write your code here
        int mod = (int)1e9+7;
        int prevA = 0;
        int prevB = 0;
        int prevC = 0;
        int n = s.length();
        
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                prevA = (((2%mod) * (prevA%mod))%mod + 1%mod)%mod;   //since a cannot stand behind anyone but can make a new line of elements
            }else if(ch == 'b'){
                prevB = (((2%mod) * (prevB%mod))%mod + prevA%mod)%mod;
            }else{
                prevC = (((2%mod) * (prevC%mod))%mod + prevB%mod)%mod;
            }
        }
        return prevC;
    }

}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String s = sc.next() ; 
        System.out.print(Solution.fun(s));
        
	}
}

