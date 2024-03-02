class Solution {
    public int removeDuplicates(int[] arr) {
        //approach 1: TreeSet approach: 
        /*
        int n = arr.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            set.add(arr[i]);
        }
        
        int k = set.size();
        for(int i=0; i<k; i++){
            int num = set.pollFirst();
            arr[i] = num;
        }
        
        return k;
        */
        
        //approach 2:
        int n = arr.length,idx = 1;
        for(int i=1; i<n; i++){
            if(arr[i-1] != arr[i]){
                arr[idx] = arr[i];
                idx++;
            }
        }
        
        return idx;
        
        //approach 3: 
        // int i = 0;
        // for (int n : arr)
        //     if (i == 0 || n > arr[i-1])
        //     arr[i++] = n;
        // return i;
    }
}
