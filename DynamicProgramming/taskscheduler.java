class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] task_freq = new int[26];
        for(char c : tasks){
            task_freq[c-'A']++;
        }
        
        Arrays.sort(task_freq);
        
        int maxValue = task_freq[25]-1;
        int idleSlots = maxValue * n;
        
        for(int i=24; i>=0; i--){
            idleSlots -= Math.min(task_freq[i],maxValue);
        }
        
        return (idleSlots > 0 ? (idleSlots + tasks.length) : tasks.length);
    }
}
