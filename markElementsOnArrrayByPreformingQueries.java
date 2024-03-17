class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        
        int n = nums.length, m = queries.length;
        
        // creating a arraylist of pair to mark the elements 
        ArrayList<Pair> list = new ArrayList<>();
        long Tsum = 0;
        
        
        for(int i=0; i<n; i++){
            Tsum += nums[i];
            list.add(new Pair(nums[i],i));
        }
        
        //sorting the elements in the list based on value
        Collections.sort(list,(x,y) -> Integer.compare(x.element,y.element));
        
        //to keep the track of the element after marking it
        int trackList = 0;
        
        long[] result = new long[m];
        
        int idx = 0;
        while(idx < m){
            long concludeSum = 0;
            int newI = queries[idx][0], KI = queries[idx][1];
            concludeSum += nums[newI];
            nums[newI] = 0;   // marking the idx as 0 to keep track;
            
            while(trackList < list.size() && KI > 0){
                if(nums[list.get(trackList).index] != 0){
                    concludeSum += list.get(trackList).element;
                    nums[list.get(trackList).index] = 0;//marking index to keep track;
                    KI--;
                }
                trackList++;
            }
            Tsum = Tsum - concludeSum;
            result[idx] = Tsum;     
          idx++;  
        }
        
        return result;
    }
}
class Pair{
    int element;
    int index;
    public Pair(int x,int y){
        this.element = x;
        this.index = y;
    }
    
}