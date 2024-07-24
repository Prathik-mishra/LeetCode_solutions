class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        
        for(int i=0; i<n; i++){
            int newNum = getMappedNum(mapping,nums[i]); 
            arr[i] = new Pair(nums[i],newNum);
        }
        
        Arrays.sort(arr,(a,b) -> Integer.compare(a.newN,b.newN));
        
        for(int i=0; i<n; i++){
            nums[i] = arr[i].n;
        }
        
        return nums;
    }
    
    private int getMappedNum(int[] mapping, int n){
        String str = Integer.toString(n);
        int num = 0;
        for(int i=0; i<str.length(); i++){
            num = num * 10 + mapping[str.charAt(i)-'0']; 
        }
        return num;
    }
}

class Pair{
    int n;
    int newN;
    public Pair(int x,int y){
        this.n = x;
        this.newN = y;
    }
}
