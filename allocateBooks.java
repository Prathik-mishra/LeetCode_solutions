link :-  https://www.codingninjas.com/studio/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTabValue=PROBLEM

import java.util.ArrayList;
public class Solution {
    public static int max(ArrayList<Integer> arr){
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            max = Math.max(i,max);
        }
        return max;
    }

    public static int sum(ArrayList<Integer> arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return sum;
    }

    public static boolean isPossible(ArrayList<Integer> arr,int mid,int m){
        int no_of_books_alloted = 0;
        int page_count = 0;
        for(int i=0; i<arr.size(); i++){
            if(page_count + arr.get(i) <= mid){
                page_count += arr.get(i);
            }else{
                no_of_books_alloted++;
                page_count = arr.get(i);
            }
        }
        return no_of_books_alloted >= m;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        //if there are more students than the book then it is impossible to distribute books to n students
        if(m > n){
            return -1;
        }
        
        //get the range:
        int low = max(arr);
        int high = sum(arr);

        //perform binary search:
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(arr,mid,m)){
                low = mid+1;   
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}
