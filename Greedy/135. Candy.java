class Solution {
    public int candy(int[] ratings) {
        //approach 1: 
        /*
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;

        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }

        int right = 1, curr = 1, summation = Math.max(curr,left[n-1]);
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                curr = right+1;
            }else{
                curr = 1;
            }

            summation += Math.max(curr,left[i]);
            right = curr;
        }

        return summation; 
        */

        //approach 2:   (SLOPE's Algo)
        int summation = 1, i=1, n=ratings.length;

        while(i<n){
            if(ratings[i-1] == ratings[i]){
                summation += 1;
                i++;
                continue;
            }

            //calculating the increasing and decreasing curve: 

            // 1. Increasing curve: 
            int peak=1;
            while(i<n && ratings[i] > ratings[i-1]){
                peak++;
                summation += peak;
                i++;
            }

            // 2. Decreasing curve: 
            int down = 1;
            while(i<n && ratings[i-1] > ratings[i]){
                summation += down;
                i++;
                down++;
            }

            if(down > peak){
                summation += (down - peak);
            }
        }

        return summation;
    }
}
