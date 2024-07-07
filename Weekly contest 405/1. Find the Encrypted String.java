class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0; i<n;i++){
            sb.append(s.charAt((i+k)%n));
        }
        return sb.toString();
    }
}

/*
      0 1 2 3
      d a r t
      where k = 3 and n = 4
      
      iteration 0 -> (0+k)%n = (0+3)%4 = 3
      iteration 1 -> (1+k)%n = (1+3)%4 = 0
      iteration 2 -> (2+k)%n = (2+3)%4 = 1
      iteration 3 -> (3+k)%n = (3+3)%4 = 2
      
      we just need to shift out index k steps from the current index 
      and remember when ever there is something sort of circular we need to think 
      that we have to keep the index in the range and to avoid overflow we use mod 
      to keep the index in range and traverse in the circular fashion
      
      T.C -> O(n);
      S.C -> O(n) this can be neglected since it is for returning and we cannot modify a string since it is immutable in nature hence it is good to say that S.C is as good as O(1)
*/
