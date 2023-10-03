class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int key:map.keySet()){
            int freq=map.get(key);
            ans+=((freq*(freq-1))/2);
        }
        
        return ans;
    }
}