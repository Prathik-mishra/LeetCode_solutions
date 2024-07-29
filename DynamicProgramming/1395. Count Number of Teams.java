class Solution {
    public int numTeams(int[] rating) {
        int tCount = 0, n = rating.length;
        for(int i=1; i<n-1; i++){
            int middleEle = rating[i];
            //for increasing subseq counts: (small - middle - large)
            
            int leftSmallerCount = 0;
            for(int j=i-1; j>=0; j--){
                if(rating[j] < middleEle){
                    leftSmallerCount++;
                }
            }
            
            int rightGreaterCount = 0;
            for(int j=i+1; j<n; j++){
                if(rating[j] > middleEle){
                    rightGreaterCount++;
                }
            }
            
            tCount += (leftSmallerCount * rightGreaterCount); 
            
            //for decreasing subseq counts: (large - middle - small)
            
            int leftGreaterCount = i - leftSmallerCount;
            int rightSmallerCount = (n - i - 1) - rightGreaterCount;
            
            tCount += (leftGreaterCount * rightSmallerCount);    
        }
        
        return tCount;
    }
}
