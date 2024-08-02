class Solution {
    public int nextGreaterElement(int n) {
        //step 1: convert int into array 
        char[] arr = Integer.toString(n).toCharArray();
        
        //step 2: get the first dip if not present return -1
        int i = arr.length-2;
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 && arr[i] >= arr[i+1]){
            i--;
        }
        
        if(i == -1) return -1;  //no dip found condition
        
        int k = arr.length-1;
        while(arr[i] >= arr[k]){
            k--;
        }
        
        swap(arr,i,k);
        
        for(int x=0; x<=i; x++){
            sb.append(arr[x]);
        }
        
        k = arr.length-1;
        while(k>i){
            sb.append(arr[k--]);
        }
        
        long _ans = Long.parseLong(sb.toString());
        
        return _ans > Integer.MAX_VALUE ? -1 : (int)_ans;
    }
    
    public void swap(char[] arr,int x,int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

/*
Explanation :-
Consider number 6537421 , firstly we convert this number to char array and check from right end
if numbers are in increasing order from right side then it means we cannot create a number more than given number because the left number's place value is always more than right one.
if there exist a number in array such that it is less than the right value , then we swap the position of number less than right value , with the number just bigger than that :-
here 6 5 3 7 4 2 1 :- 3 is the first number which is less than right values so swap 3 , 4
now the number becomes 6 5 4 7 3 2 1 :- but this is not the least number , to get least number we reverse the numbers from 7 to 1 ie 7 3 2 1 -> 1 2 3 7 and we add this to existing ans:-
final answer 6 5 4 1 2 3 7
*/
