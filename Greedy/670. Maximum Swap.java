class Solution {
    public int maximumSwap(int num) {
        int temp = num;
        StringBuilder sb = new StringBuilder();

        while(num != 0){
            int rem = num % 10;
            sb.append(rem);
            num = num/10;
        }

        sb = sb.reverse();
        int replacableIdx = -1;

        for(int i=0; i<sb.length(); i++){
            for(int j=i+1; j<sb.length(); j++){
                if(sb.charAt(j) > sb.charAt(i)){
                    if(replacableIdx == -1){
                        replacableIdx = j;
                    }
                    else if(replacableIdx != -1 && sb.charAt(replacableIdx) <= sb.charAt(j)){
                        replacableIdx = j;
                    }
                }  
            }
            if(replacableIdx != -1){
                return (int) (Integer.parseInt(replace(sb,i,replacableIdx))); 
            }
        }

        return Integer.parseInt(sb.toString());
    }

    String replace(StringBuilder sb, int x, int y){
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<sb.length(); i++){
            if(i == x){
                res.append(sb.charAt(y));
            }else if(i == y){
                res.append(sb.charAt(x));
            }else{
                res.append(sb.charAt(i));
            }
        }

        return res.toString();
    } 
}
