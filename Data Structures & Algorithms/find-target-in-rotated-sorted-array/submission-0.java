class Solution {
    public int search(int[] nums, int target) {
        int start = 0 ;
        int end = nums.length -1 ;

        while(start < end){
            int mid = (start + end) / 2;
            
            if(nums[mid] > nums[end] ){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        int pivot = start;
        int result = binarySearch( nums, target,0,pivot - 1);

        if(result != -1 ){
            return result;
        }
        return binarySearch( nums, target,pivot,nums.length -1 );

    }

    public int binarySearch(int []nums,int target,int start ,int end){
        while(start <= end){
            int mid = (start + end )/2;

            if(nums[mid] < target){
                start  = mid + 1; 
            }else if (nums[mid] > target){
                end = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
