class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        //sorting O(2 * nlogn) + O(n) 
        /*
        Arrays.sort(target);
        Arrays.sort(arr);
        int n = target.length;

        for(int i=0; i<n; i++){
            if(target[i] != arr[i]){
                return false;
            }
        }

        return true;
        */

        //using hashMap O(n) and sc o(n):
        /*
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int n = target.length;
        
        for(int i=0; i<n; i++){
            hmap.put(target[i],hmap.getOrDefault(target[i],0)+1);
        }

        for(int i=0; i<n; i++){
            if(!hmap.containsKey(arr[i]) || hmap.get(arr[i]) <= 0){
                return false;
            }
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)-1);
        }

        return true;
        */

        //freq map since the values are in range of 1 - 1000: O(n) + O(1) constant space
        int[] freq1 = new int[1001];
        int[] freq2 = new int[1001];
        int n = target.length; 

        for(int i=0; i<n; i++){
            freq1[arr[i]]++;
            freq2[target[i]]++;
        }

        for(int i=1; i<1001; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }

        return true;
    }
}
