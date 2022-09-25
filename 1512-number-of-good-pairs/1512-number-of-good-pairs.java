class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:nums){
            if(map.containsKey(num)){
                ans+=map.get(num);
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return ans;
    }
}