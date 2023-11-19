class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int ans=0;
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Integer> list=new ArrayList<>();
        for(int key:map.keySet()){
           list.add(map.get(key)); 
        }
        
        for(int i=list.size()-1;i>=0;i--){
            int freq=list.get(i);
            int steps=i;
            ans+=freq*steps;
        }
        
        return ans;
    }
}