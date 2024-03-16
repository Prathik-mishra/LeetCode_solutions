class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += encrypted(nums[i]);
        }
        
        return sum;
    }
    
    public int encrypted(int num){
        char maxNum = '0';
        char[] digits = String.valueOf(num).toCharArray();
        
        for(char digit : digits){
            if(digit > maxNum){
                maxNum = digit;      
            }
        }
        
        String encryptedNumber = String.valueOf(maxNum).repeat(digits.length);
        
        return Integer.parseInt(encryptedNumber);
    }
}
