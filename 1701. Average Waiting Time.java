class Solution {
    public double averageWaitingTime(int[][] customers) {
        int size = customers.length;
        long sum = 0;
        long lastTime = 1;
        for(int i=0; i<size; i++){
            long entryTime = customers[i][0];
            long timeTaken = Math.max(entryTime,lastTime) + customers[i][1];
            long wait = timeTaken - entryTime;
            lastTime = timeTaken;
            sum += wait;
        }
        
        return (double) (sum)/(size);
    }
}
