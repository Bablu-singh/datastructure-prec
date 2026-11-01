// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(0,pairs.size()-1,pairs);
    }
    public List<Pair> mergeSortHelper(int start,int end,List<Pair> pairs){
        if(end-start+1<=1){
            return pairs;
        }
        int middle = (start+end)/2;

        mergeSortHelper(start,middle,pairs);
        mergeSortHelper(middle+1,end,pairs);
        merge(start,middle,end,pairs);
        return pairs;
    }

    public void merge(int start,int middle, int end,List<Pair> pairs){
        List<Pair> left = new ArrayList<>(pairs.subList(start,middle+1));
        List<Pair> right = new ArrayList<>(pairs.subList(middle+1,end+1));

        int i = 0;
        int j = 0;
        int k = start;

        while(i<left.size() && j<right.size()){
            if(left.get(i).key <= right.get(j).key){
                pairs.set(k,left.get(i));
                i++;
            }
            else{
                pairs.set(k,right.get(j));
                j++;
            }
            k++;
        }
        while(i<left.size()){
            pairs.set(k,left.get(i));
            i++;
            k++;
        }
        while(j<right.size()){
            pairs.set(k,right.get(j));
            j++;
            k++;
        }
    }
}
