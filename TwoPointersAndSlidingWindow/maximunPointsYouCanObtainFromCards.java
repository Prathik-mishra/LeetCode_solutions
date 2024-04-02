class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        
        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }
        
        //since we have to take all the cards:
        if(k == cardPoints.length){
            return leftSum;
        }
        
        int rightIdx = cardPoints.length-1;
        int maxPoints = leftSum;
        for(int i=k-1; i>=0; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIdx--];
            maxPoints = Math.max(maxPoints,(leftSum+rightSum));
        }
        
        return maxPoints;
    }
}