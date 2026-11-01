class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }


        int start = 0;
        int end = A.length;
        


        while(start <= end){
            int midA = (start + end) /2;
            int midB = (half - midA);

            int Astart = midA > 0 ? A[midA - 1] : Integer.MIN_VALUE;
            int Aend = midA < A.length ? A[midA] : Integer.MAX_VALUE; 

            int Bstart = midB > 0 ? B[midB -1] : Integer.MIN_VALUE;
            int Bend =midB < B.length ? B[midB] : Integer.MAX_VALUE;

            if(Astart <= Bend && Bstart<=Aend){

                if(total % 2 != 0){
                    return (Math.max(Astart, Bstart));
                }
                return (Math.max(Astart, Bstart) + Math.min(Aend, Bend))/2.0;
                  
            }else if(Astart > Bend){
                end = midA-1;
            }else {
                start = (midA + 1);
            }
        }
        return -1;
    }
}
