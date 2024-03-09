class Solution {
    public int findMin(int[] arr) {
        // 1st approach saksham sir's: 
//        int n = arr.length;
//        int start = 0;
//        int end = n-1;
       
//        while(start <= end)
//        {
//            int mid = (start + end)/2;
           
//            // can this mid be the minimum element
//            // if left is unsorted then go to left part
//            // if right is unsorted then go to right part
//            // if both are sorted then we can say answer is arr[st]
           
//            //1st type without modulo: 
//            // if(mid == 0 && arr[mid] < arr[mid+1])
//            // {
//            //     return arr[mid];
//            // }
           
//            // if(mid == (n-1) && arr[mid-1] > arr[mid])
//            // {
//            //     return arr[mid];
//            // }
//            // if(arr[(mid-1+n)%n] > arr[mid] && arr[mid] < arr[(mid+1)%n])
//            // {
//            //     return arr[mid];
//            // }
           
//            //2nd type of logic using modulo:
//            if(arr[(mid-1+n)%n] > arr[mid] && arr[mid] < arr[(mid+1)%n])
//            {
//                return arr[mid];
//            }
           
//            if(arr[start] > arr[mid])
//            {
//                // left part is unsorted so we go to left part
//                end = mid - 1;
//            }
//            else if(arr[mid] > arr[end])
//            {
//                // right part is unsorted so we go to right part
//                start = mid + 1;
//            }
//            else 
//            {
//                // if both are sorted, current part of array is sorted so minimum will be first element
//                return arr[start];
//            }
//        }
//        return arr[0];

        //2nd approach strivers:
        int start = 0,end = arr.length-1;
        int ans = Integer.MAX_VALUE;
        
        while(start <= end){
            int mid = (start+end)/2;
            //a special optimization if array has no or 0 rotation: 
            if(arr[start] <= arr[end]){
                ans = Math.min(ans,arr[start]);
            }
            
            //if right part is sorted then comparing it with the smaller and eleminating right part
            if(arr[start] <= arr[mid]){
                ans = Math.min(ans,arr[start]);
                start = mid+1;
            //if left part is sorted then comparing it with the smaller and eleminating left part
            }else{
                ans = Math.min(ans,arr[mid]);
                end = mid-1;
            }
        }
        return ans;
    }
}
