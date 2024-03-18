class Solution {
    public int findMinArrowShots(int[][] points) {
        
        //at first sight i guessed like this but it is not 
        //this problem is same as merge interval but in this it just we have to return the number of intervals we get after merging the array points:
        
        Arrays.sort(points,(x,y) -> Integer.compare(x[1],y[1]));
        int n = points.length;
        int pointer = 0;
        int arrows = 0;
        
        while(pointer < n){
            int compare = pointer + 1;
            while(compare < n && points[pointer][1] >= points[compare][0]){
                compare++;
            }
            pointer = compare;
            arrows++;
        }
        return arrows;
    }
}