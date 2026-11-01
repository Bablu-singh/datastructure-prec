class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        List<Integer> freq[] = new ArrayList[n+1];

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i =0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }
        for(int key : map.keySet()){
            int value = map.get(key);
                freq[value].add(key);
            }
        int [] res = new int[k];
        int index = 0;
        for(int i = freq.length-1;i>=0 && index < k;i--){
            for(int item: freq[i]){
                res[index++] = item;
                if(index == k){
                    return res;
                }
            }
        }




        return res;
    }
}
