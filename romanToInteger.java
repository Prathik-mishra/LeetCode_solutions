class Solution {
    //    private int valueOfSymbol(char c){
    // 		switch(c){
    // 			case 'I':
    // 				return 1;
    // 			case 'V':
    // 				return 5;
    // 			case 'X':
    // 				return 10;
    // 			case 'L':
    // 				return 50;
    // 			case 'C':
    // 				return 100;
    // 			case 'D':
    // 				return 500;
    // 			case 'M':
    // 				return 1000;	
    // 			default:
    // 				return 0;
    // 		}
    // 	}
        
        public int romanToInt(String str) {
    //        int idx = 0;
    // 		int num = 0;
    // 		while(idx + 1 < str.length()){
    // 			int a = valueOfSymbol(str.charAt(idx));
    // 			int b = valueOfSymbol(str.charAt(idx+1));
    
    // 			if(a>=b){
    // 				num += a;
    // 				idx++;
    // 			}else{
    // 				num += (b - a);
    // 				idx += 2;
    // 			}
    // 		}
    // 		 if(idx == str.length()-1){
    // 			 num += valueOfSymbol(str.charAt(idx));
    // 		 }
    
    // 		return num;
            
            int ans = 0, num = 0;
            for (int i = str.length()-1; i >= 0; i--) {
                switch(str.charAt(i)) {
                    case 'I': num = 1; break;
                    case 'V': num = 5; break;
                    case 'X': num = 10; break;
                    case 'L': num = 50; break;
                    case 'C': num = 100; break;
                    case 'D': num = 500; break;
                    case 'M': num = 1000; break;
                }
                if (4 * num < ans) ans -= num;
                else ans += num;
            }
            return ans;
        
        }
    }
