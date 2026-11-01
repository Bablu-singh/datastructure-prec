class Solution {
    public int search(int[] nums, int target) {
        
        
        int pivot = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                pivot = i;
                break;
            }
        }


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
