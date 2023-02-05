class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
        for(int num:basket1){
            map.merge(num,1,Integer::sum);
        }
        for(int num:basket2){
            map.merge(num,-1,Integer::sum);
        }
        List<Integer> swaps=new ArrayList<Integer>();
        long res=0;
        long small=map.firstKey();
        for(int key:map.keySet()){
            if(map.get(key)%2==1){
                return -1;
            }
            int freq=Math.abs(map.get(key))/2;
            for(int i=0;i<freq;i++){
                swaps.add(key);
            }
        }
        for(int i=0;i<swaps.size()/2;i++){
            res+=Math.min(swaps.get(i),small*2);
        }
        return res;
    }
}