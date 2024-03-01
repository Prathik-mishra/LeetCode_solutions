class Solution {
    public String maximumOddBinaryNumber(String s) {
        //approach 1 :- brute force: TC :- O(nlogn) and SC :- O(n);
        /*
        int n = s.length();  
        char arr[] = s.toCharArray();
        Arrays.sort(arr);      
        int i = 0, j = n-2;
        while(i<j){   
            //swap: 
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
        */
        
        //approach 2:- counting 1 and building a new String: TC :- O(n+n) and SC :- O(n)
        /*
        int n = s.length(), count1 = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1') count1++;
        }
        
         // Use StringBuilder for fast concatenation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count1 - 1; i++) {
            sb.append("1");
        }
        for (int i = 0; i < n - count1; i++) {
            sb.append("0");
        }
        sb.append("1");
        
        return sb.toString();
        */
        
        //approach 3 two pointer with 0s 1s swaping algo : TC :- O(n) and SC :- O(n)
        char[] arr = s.toCharArray();
        int N = arr.length;
        
        // Initialize two pointers
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            
            // Increment left if equals 1
            if (arr[left] == '1') {
                left++;
            }
            // Decrement right if equals 0
            if (arr[right] == '0') {
                right--;
            }
            // Swap if neither pointer can be iterated
            if (left <= right && arr[left] == '0' && arr[right] == '1') {
                arr[left] = '1';
                arr[right] = '0';
            }
        }

        // Swap rightmost 1 bit to the end
        arr[left - 1] = '0';
        arr[N - 1] = '1';

        return new String(arr);
    }
}
