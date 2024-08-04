class Solution {
    private static int mod = (int) 1e9+7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> subArraySumLis = new ArrayList<>();
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                subArraySumLis.add(sum);
            }
        }

        Collections.sort(subArraySumLis);

        int finalSum = 0;
        for(int L=left; L<=right; L++){
            finalSum = (finalSum + subArraySumLis.get(L-1))%mod;
        }
        return finalSum;
    }
}
