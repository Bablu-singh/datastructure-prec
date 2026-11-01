class Solution {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        int min = arr[0];

        while (start <= end ) {

            if(arr[start] < arr[end]){
                min = Math.min(min, arr[start]);
                break;
            }

            int mid = (start + end ) / 2;
            min = Math.min( min, arr[mid]);
            if( arr[mid] >= arr[start]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return min;
    }
}
