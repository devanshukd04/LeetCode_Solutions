class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeSet<Integer> set=new TreeSet<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:arr1){
            set.add(num);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int i=0;
        for(int num:arr2){
            int freq=map.get(num);
            for(int j=0;j<freq;j++){
                arr1[i]=num;
                i++;
            }
            set.remove(num);
        }
        for(int num:set){
            int freq=map.get(num);
            for(int j=0;j<freq;j++){
                arr1[i]=num;
                i++;
            }
        }
        return arr1;
    }
}