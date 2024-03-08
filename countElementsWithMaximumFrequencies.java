class Solution {
    public int maxFrequencyElements(int[] nums) {
        //approach 1 L brute force:
        /*
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(hmap.containsKey(nums[i])){ 
                hmap.put(nums[i],hmap.get(nums[i])+1);
            }else{ 
                hmap.put(nums[i],1);
            }
        }
               
        int maxOccured  = 0;
        for(int i : hmap.keySet()){
            maxOccured = Math.max(maxOccured,hmap.get(i));
        }
        
        int maxEle = 0;
        for(int i : hmap.keySet()){
            if(hmap.get(i) == maxOccured){
                maxEle += maxOccured;
            }
        }
               
        return maxEle;
        */

        //approach 2 using freqArray and sorting:

        // Find the frequency of each element
        /*
        int[] frequencies = new int[100];
        for (int num : nums) {
            frequencies[num - 1]++;
        }

        // Determine the maximum frequency, stored in the last index of the sorted array
        Arrays.sort(frequencies);
        int maxFreqIndex = frequencies.length - 1;
        int totalFrequencies = frequencies[maxFreqIndex];

        // Calculate the total frequencies of elements with the maximum frequency
        // Start from the last index and iterate right to left
        while (maxFreqIndex > 0 && frequencies[maxFreqIndex] == frequencies[maxFreqIndex - 1]) {
            totalFrequencies += frequencies[maxFreqIndex];
            maxFreqIndex--;
        }
        return totalFrequencies;
         */
        

        //approach 3 one pass solution:
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int maxFreq = 0;
        int maxFreqElements = 0;

        for(int i : nums){
            hmap.put(i,hmap.getOrDefault(i,0)+1);
            int currEleFreq = hmap.get(i);

            if(currEleFreq > maxFreq){
                maxFreq = currEleFreq;
                maxFreqElements = currEleFreq;
            }else if(currEleFreq == maxFreq){
                maxFreqElements += currEleFreq;
            }
        }

        return maxFreqElements;
    }
}
