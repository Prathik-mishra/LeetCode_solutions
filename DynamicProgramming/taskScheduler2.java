class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long current = 0;
        HashMap<Integer,Long> hmap = new HashMap<>();
        
        for(int i=0; i<tasks.length; i++){
            if(hmap.containsKey(tasks[i])){
                current = Math.max(current,hmap.get(tasks[i])+space)+1;
                hmap.put(tasks[i],current);
            }else{
                current = current + 1;
                hmap.put(tasks[i],current);
            }
        }
        return current; 
    }
}

/*
//wrong code: may be need to debug later
long count = 0;
        long wait = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        for(int i=0; i<tasks.length; i++){
            if(hmap.containsKey(tasks[i])){
                int tasksDone = (i-1) - hmap.get(tasks[i]);
                if(tasks[i] == tasks[i-1]){
                    count += space + 1;
                    wait = 0;
                }
                if(tasksDone+wait >= space){
                    count += 1;
                    wait = 0;
                }else{
                    wait = space - tasksDone;
                    count += wait+1;
                }
                hmap.put(tasks[i],i);
            }else{
                hmap.put(tasks[i],i);
                count += 1;
                wait = 0;
            }
        }
        return count; 


count = 1 2 (3+2)5 6 7 (8+1)9  
wait = 0 0 2 0 0 1
[1,0] [2,1] [1,2] [2,2] [3,3] [1,4]

count = 1 2 (3+2)5 6 
wait = 0 0 2 0
[5,0] [8,1] [8,2] [5,3]

count = 1 
wait = 0 1
[9,0] [9,1]
*/