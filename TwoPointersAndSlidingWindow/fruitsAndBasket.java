public class Solution {
    public static int findMaxFruits(int []arr, int n) {
        // Write your code here.
        //approach 1: brute force generate all the sub arrays  TC :- O(N^2)

        //approach 2: sliding window TC :- O(2*N)
        int maxLen = 0;
        int i=0,j=0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        while(j<n){
            int num = arr[j];
            hmap.put(num,hmap.getOrDefault(num,0)+1);

            while(i<=j && hmap.size() > 2){
                hmap.put(arr[i],hmap.getOrDefault(arr[i],0)-1);
                if(hmap.get(arr[i]) == 0){
                    hmap.remove(arr[i]);
                }
                i++;
            }

            maxLen = Math.max(maxLen,(j-i)+1);
            j++;
        }
        return maxLen;
    }
}
