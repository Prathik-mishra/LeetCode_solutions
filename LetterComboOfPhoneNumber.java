class Solution {
    private static String[] key = {"","", "abc" ,"def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"}; 
    
    public List<String> letterCombinations(String digits) {
        List<String> combi = new ArrayList<>();
        if(digits.isEmpty()) return combi;
        helper(0,digits,"",combi);
		return combi;
    }
    
    static void helper(int n, String digits, String ans,List<String> combi){
		if(n >= digits.length()){
			combi.add(ans);
			return;
		}

		char idx = digits.charAt(n);
		String str = key[idx - '0'];

		for(int i = 0 ; i < str.length() ; i++){
			helper(n+1,digits,ans+str.charAt(i),combi);
		}
	}
}