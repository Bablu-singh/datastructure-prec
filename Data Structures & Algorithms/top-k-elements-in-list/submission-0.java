
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        List<Integer> [] freq = new List[nums.length+1];

        for(int i = 0 ;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }

        for(int f : map.keySet()){
            int value = map.get(f);
            freq[value].add(f);
        }

        int [] res = new int[k];
        int index = 0;

        for(int i = freq.length - 1 ;i>0 && index < k;i--){
            for(int n : freq[i]){
                res[index++] = n;
                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
