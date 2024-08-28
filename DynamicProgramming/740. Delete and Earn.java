class Solution {
    private static HashMap<Integer,Integer> hmap;
    public int deleteAndEarn(int[] nums) {
        hmap = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            hmap.put(nums[i], hmap.getOrDefault(nums[i],0)+1);
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for(int key : hmap.keySet()){
            lis.add(key);
        }

        Collections.sort(lis);

        // return func(lis,0);

        // int[] dp = new int[lis.size()+1];
        // Arrays.fill(dp,-1);

        // return func(lis,0,dp);

        return tabulation(lis,lis.size());
    }

    private int tabulation(ArrayList<Integer> lis, int n){
        int[] dp = new int[lis.size()+1];

        for(int i=n; i>=0; i--){
            if(i == lis.size()-1){
                dp[i] = hmap.get(lis.get(i)) * lis.get(i);
                continue;
            }else if(i == lis.size()){
                dp[i] = 0;
                continue;
            }

            int pick = Integer.MIN_VALUE;
            if(i+2 <= lis.size()){
                if(lis.get(i)+1 == lis.get(i+1)){
                    pick = (hmap.get(lis.get(i)) * lis.get(i)) + dp[i+2];
                }else{
                    pick = (hmap.get(lis.get(i)) * lis.get(i)) + dp[i+1];
                }
            }
            int notPick = dp[i+1]; //func(lis,i+1,dp);

            dp[i] = Math.max(pick,notPick);
        }

        return dp[0];
    }

    private int func(ArrayList<Integer> lis, int i, int[] dp){
        if(i == lis.size()-1){
            return hmap.get(lis.get(i)) * lis.get(i);
        }

        if(i == lis.size()){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int pick = Integer.MIN_VALUE;
        if(i+2 <= lis.size()){
            if(lis.get(i)+1 == lis.get(i+1)){
                pick = (hmap.get(lis.get(i)) * lis.get(i)) + func(lis,i+2,dp);
            }else{
                pick = (hmap.get(lis.get(i)) * lis.get(i)) + func(lis,i+1,dp);
            }
        }
        int notPick = func(lis,i+1,dp);

        return dp[i] = Math.max(pick,notPick);
    }

    private int func(ArrayList<Integer> lis, int i){
        if(i == lis.size()-1){
            return hmap.get(lis.get(i)) * lis.get(i);
        }

        if(i == lis.size()){
            return 0;
        }

        int pick = Integer.MIN_VALUE;
        if(i+2 <= lis.size()){
            if(lis.get(i)+1 == lis.get(i+1)){
                pick = (hmap.get(lis.get(i)) * lis.get(i)) + func(lis,i+2);
            }else{
                pick = (hmap.get(lis.get(i)) * lis.get(i)) + func(lis,i+1);
            }
        }
        int notPick = func(lis,i+1);

        return Math.max(pick,notPick);
    }
}
